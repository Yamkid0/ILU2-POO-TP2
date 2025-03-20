package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
			if(gaulois != null && gaulois.length > 0) {
				StringBuilder bld = new StringBuilder();
				bld.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
				for(int i = 0; i < gaulois.length;i++) {
					bld.append((i+1) + " - " + gaulois[i].getNom()+"\n");
				}
				int numGaulois;
				do {
					numGaulois = Clavier.entrerEntier(bld.toString());
				} while(numGaulois < 0 || numGaulois > gaulois.length);
				String nomVendeur = gaulois[numGaulois-1].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " +nomVendeur);
				int nbProduit = Clavier.entrerEntier("Bonjour "+ nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
				Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
				if(etal.getQuantite() == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheuresement il n'y en a plus !");
				}else if(etal.getQuantite() < nbProduit) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheuresement " + nomVendeur + " n'en a plus que " + etal.getQuantite() + " " + nomAcheteur + " achète tout le stock de " + nomVendeur);
					etal.acheterProduit(etal.getQuantite());
				} else if (etal.getQuantite() >= nbProduit) {
					etal.acheterProduit(nbProduit);
					System.out.println(nomAcheteur + " achète 5 fleurs à " + nomVendeur);
				}
				
				
			} else {
				System.out.println("Désolé personne ne vend ce produit au marché");
			}
			
		} else {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

}

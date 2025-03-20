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
				bld.append("Chez quel commer�ant voulez-vous acheter des fleurs ?\n");
				for(int i = 0; i < gaulois.length;i++) {
					bld.append((i+1) + " - " + gaulois[i].getNom()+"\n");
				}
				int numGaulois;
				do {
					numGaulois = Clavier.entrerEntier(bld.toString());
				} while(numGaulois < 0 || numGaulois > gaulois.length);
				String nomVendeur = gaulois[numGaulois-1].getNom();
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " +nomVendeur);
				int nbProduit = Clavier.entrerEntier("Bonjour "+ nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?");
				Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
				if(etal.getQuantite() == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheuresement il n'y en a plus !");
				}else if(etal.getQuantite() < nbProduit) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheuresement " + nomVendeur + " n'en a plus que " + etal.getQuantite() + " " + nomAcheteur + " ach�te tout le stock de " + nomVendeur);
					etal.acheterProduit(etal.getQuantite());
				} else if (etal.getQuantite() >= nbProduit) {
					etal.acheterProduit(nbProduit);
					System.out.println(nomAcheteur + " ach�te 5 fleurs � " + nomVendeur);
				}
				
				
			} else {
				System.out.println("D�sol� personne ne vend ce produit au march�");
			}
			
		} else {
			System.out.println("Je suis d�sol� " + nomAcheteur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}
	}

}

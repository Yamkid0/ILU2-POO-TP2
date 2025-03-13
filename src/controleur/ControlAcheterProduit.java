package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
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
			if(gaulois.length > 0) {
				StringBuilder bld = new StringBuilder();
				bld.append("Chez quel commerçant vouslez-+vous acheter des fleurs ?\n");
				for(int i = 0; i < gaulois.length;i++) {
					bld.append(" - " + gaulois[i].getNom()+"\n");
				}
				int etal = Clavier.entrerEntier(bld.toString());
				//todo ajouter test étal
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + gaulois[etal].getNom());
				int nbProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
			} else {
				System.out.println("Désolé personne ne vend ce produit au marché");
			}
			
		} else {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

}

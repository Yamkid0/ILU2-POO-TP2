package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol�e " + nomAcheteur + " mais il faut �tre habitant "
					+ " de notre village pour commercer ici.");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] vendeursProduit = controlAcheterProduit.vendeursProduit(produit);
			if(vendeursProduit != null) {
								
				int vendeur = -1;
				do {
					System.out.println("Chez quel commer�ant voulez-vous acheter des " + produit + " ?");
					for(int i=0; i<vendeursProduit.length; i++) {
						System.out.println((i+1) + " - " + vendeursProduit[i]);
					}
					vendeur = Clavier.entrerEntier("");
				}while(vendeur > vendeursProduit.length || vendeur<=0);
				String nomVendeur = vendeursProduit[vendeur-1];
				
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " 
				+ nomVendeur + ".");
				
				int quantiteDemandee = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantite = controlAcheterProduit.getQuantiteProduit(nomVendeur);
				if(quantite == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " "
							+ produit + " malheureusement il n�y en a plus !");
				}
				else if(quantite < quantiteDemandee) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " " +
							produit + ", malheureusement " + nomVendeur + " n'en a plus que " + quantite + ". "
							+ nomAcheteur + " ach�te tout le stock de " + nomVendeur + ".");
					controlAcheterProduit.acheterProduit(nomVendeur, quantiteDemandee);
				}
				else {
					System.out.println(nomAcheteur + " ach�te " + quantiteDemandee + " " + produit
							+ " � " + nomVendeur + ".");
					controlAcheterProduit.acheterProduit(nomVendeur, quantiteDemandee);

				}
			}
			else {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
		}
	}
}
package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le march� est vide, revenez plus tard.");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au march�:");
			StringBuilder str = new StringBuilder();
			int i = 0;
			while(i < infosMarche.length) {
				str.append(" - ");
				str.append(infosMarche[i] + " qui vend ");
				i++;
				str.append(infosMarche[i]);
				i++;
				str.append(" "+infosMarche[i] + "\n");
				i++;
			}
			System.out.println(str.toString());
		}
	}
}

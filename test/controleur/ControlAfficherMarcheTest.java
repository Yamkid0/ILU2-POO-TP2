package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	Village village;
	Chef abraracourcix;
	ControlAfficherMarche ctrol;
	Gaulois obelix;
	
	@BeforeEach
	private void initConfig() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 10);
		ctrol = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(ctrol,"Controlleur non null");
	}

	@Test
	void testDonnerInfosMarche() {
		String[] resultat = ctrol.donnerInfosMarche();
		assertEquals(resultat[0], obelix.getNom());
		assertEquals(resultat[1],"10");
		assertEquals(resultat[2], "menhir");
		assertEquals(resultat.length,3);
	}

}

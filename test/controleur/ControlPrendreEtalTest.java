package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	ControlPrendreEtal ctrol;
	ControlVerifierIdentite ctrolVerifId;
	Village village;
	Chef abraracourcix;
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrolVerifId = new ControlVerifierIdentite(village);
		ctrol = new ControlPrendreEtal(ctrolVerifId,village);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(ctrol);
	}

	@Test
	void testResteEtals() {
		assertTrue(ctrol.resteEtals());
		village.installerVendeur(obelix, "ménhir", 10);
		assertFalse(ctrol.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ctrol.prendreEtal(obelix.getNom(), "ménhir", 10);
		assertNotNull(village.rechercherEtal(obelix));
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(ctrol.verifierIdentite(obelix.getNom()));
		assertFalse(ctrol.verifierIdentite("Personnix"));
	}

}

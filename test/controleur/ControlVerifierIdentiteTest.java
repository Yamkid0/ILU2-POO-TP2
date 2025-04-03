package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	ControlVerifierIdentite ctrol;
	Village village;
	Chef abraracourcix;
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irr�ductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrol = new ControlVerifierIdentite(village);
		obelix = new Gaulois("Ob�lix", 10);
		village.ajouterHabitant(obelix);
	}
	
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(ctrol);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(ctrol.verifierIdentite(obelix.getNom()));
		assertFalse(ctrol.verifierIdentite("Ast�rix"));
	}

}

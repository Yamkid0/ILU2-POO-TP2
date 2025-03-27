package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	ControlTrouverEtalVendeur ctrol;
	Village village;
	Chef abraracourcix;
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrol = new ControlTrouverEtalVendeur(village);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(ctrol);
	}

	@Test
	void testTrouverEtalVendeur() {
		fail("Not yet implemented");
	}

}

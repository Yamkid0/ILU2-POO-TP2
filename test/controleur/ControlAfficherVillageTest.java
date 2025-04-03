package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	ControlAfficherVillage ctrol;
	Village village;
	Chef abraracourcix;
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrol = new ControlAfficherVillage(village);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(ctrol,"Controlleur non null");
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(2,ctrol.donnerNomsVillageois().length);
		assertEquals("Abraracourcix",ctrol.donnerNomsVillageois()[0]);
		assertEquals("Obélix",ctrol.donnerNomsVillageois()[1]);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(village.getNom(), ctrol.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(1,village.donnerNbEtal());
	}

}

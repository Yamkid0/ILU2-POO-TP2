package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlVerifierIdentite;
import villagegaulois.Village;

class GauloisTest {
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		obelix = new Gaulois("Obélix", 10);
	}
	
	@Test
	void testToString() {
		assertEquals("Gaulois [nom=Obélix, force=10, effetPotion=1]", obelix.toString());
	}

	@Test
	void testGaulois() {
		assertNotNull(obelix);
	}
	
	@Test 
	void testPrendreParole() {
		assertEquals("Le gaulois Obélix : ",obelix.prendreParole());
	}
}

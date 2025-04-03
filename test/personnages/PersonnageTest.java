package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlVerifierIdentite;
import villagegaulois.Village;

class PersonnageTest {
	Personnage obelix;
	
	@BeforeEach
	void initConfig() {
		obelix = new Personnage("Ob�lix",10);
	}
	
	@Test
	void testPersonnage() {
		assertNotNull(obelix);
	}

	@Test
	void testGetForce() {
		assertEquals(10, obelix.getForce());
	}

	@Test
	void testGetNom() {
		assertEquals("Ob�lix", obelix.getNom());
	}

	@Test
	void testToString() {
		assertEquals("[nom=Ob�lix, force=10]", obelix.toString());
	}



}

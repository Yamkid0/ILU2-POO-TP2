package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

class EtalTest {
	Etal etalOccupe;
	Etal etalVide;
	Gaulois obelix;
	
	@BeforeEach
	void initConfig() {
		etalOccupe = new Etal();
		etalVide = new Etal();
		obelix = new Gaulois("Obélix", 10);
		etalOccupe.occuperEtal(obelix, "menhir", 10);
	}
	
	@Test
	void testIsEtalOccupe() {
		assertTrue(etalOccupe.isEtalOccupe());
		assertFalse(etalVide.isEtalOccupe());
	}

	@Test
	void testGetVendeur() {
		assertEquals(obelix, etalOccupe.getVendeur());
		assertEquals(null, etalVide.getVendeur());
	}

	@Test
	void testGetQuantite() {
		assertEquals(10, etalOccupe.getQuantite());
		assertEquals(0,etalVide.getQuantite());
	}

	@Test
	void testGetProduit() {
		assertEquals("menhir", etalOccupe.getProduit());
		assertNull(etalVide.getProduit());
	}

	@Test
	void testOccuperEtal() {
		assertFalse(etalVide.isEtalOccupe());
		etalVide.occuperEtal(obelix, "menhir", 10);
		assertTrue(etalVide.isEtalOccupe());
	}

	@Test
	void testContientProduit() {
		assertTrue(etalOccupe.contientProduit("menhir"));
		assertFalse(etalOccupe.contientProduit("rpg7"));
	}

	@Test
	void testAcheterProduit() {
		assertEquals(10, etalOccupe.getQuantite());
		etalOccupe.acheterProduit(5);
		assertEquals(5, etalOccupe.getQuantite());
		etalOccupe.acheterProduit(7);
		assertEquals(0, etalOccupe.getQuantite());
	}

	@Test
	void testLibererEtal() {
		assertTrue(etalOccupe.isEtalOccupe());
		etalOccupe.libererEtal();
		assertFalse(etalOccupe.isEtalOccupe());
	}

	@Test
	void testEtatEtal() {
		/*donneesVente[0] = String.valueOf(etalOccupe);
			donneesVente[1] = vendeur.getNom();
			donneesVente[2] = produit;
			donneesVente[3] = String.valueOf(quantiteDebutMarche);
			donneesVente[4] = String.valueOf(quantiteDebutMarche - quantite);*/
		String[] etat = etalOccupe.etatEtal();
		assertEquals("true",etat[0]);
		assertEquals("Obélix", etat[1]);
		assertEquals("menhir", etat[2]);
		assertEquals("10", etat[3]);
		assertEquals("0", etat[4]);
		etalOccupe.acheterProduit(5);
		etat = etalOccupe.etatEtal();
		assertEquals("5", etat[4]);
	}

}

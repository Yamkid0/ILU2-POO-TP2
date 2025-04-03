package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	ControlTrouverEtalVendeur ctrlEtalVendeur;
	ControlVerifierIdentite ctrlVerifIdentite;
	Village village;
	Chef abraracourcix;
	ControlAcheterProduit ctrol;
	Gaulois obelix;
	Gaulois asterix;
	
	@BeforeEach
	private void initConfig() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrlVerifIdentite = new ControlVerifierIdentite(village);
		ctrlEtalVendeur = new ControlTrouverEtalVendeur(village);
		ctrol = new ControlAcheterProduit(ctrlVerifIdentite, ctrlEtalVendeur, village);
		obelix = new Gaulois("Obélix", 10);
		asterix = new Gaulois("Astérix",5);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.installerVendeur(obelix, "menhir", 10);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(ctrol,"Controlleur non null");
	}

	@Test
	void testAcheterProduit() {
		assertEquals(village.rechercherEtal(obelix).getQuantite(), 10);
		ctrol.acheterProduit(obelix.getNom(),5);
		assertEquals(village.rechercherEtal(obelix).getQuantite(), 5);
	}
	
	@Test
	void testVerifierIdentite() {
		assertEquals(true,ctrol.verifierIdentite(asterix.getNom()));
		assertEquals(false,ctrol.verifierIdentite("Panoramix"));
	}
	
	@Test
	void testGetQuantiteProduit() {
		assertEquals(ctrol.getQuantiteProduit(obelix.getNom()), 10);
	}
	
	@Test
	void testVendeursProduit() {
		assertEquals(1,ctrol.vendeursProduit("menhir").length);
		assertNull(ctrol.vendeursProduit("navire"));
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	ControlLibererEtal ctrol;
	ControlTrouverEtalVendeur ctrolEtalVendeur;
	Village village;
	Chef abraracourcix;
	Gaulois obelix;
	Gaulois test;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctrolEtalVendeur = new ControlTrouverEtalVendeur(village);
		ctrol = new ControlLibererEtal(ctrolEtalVendeur);
		obelix = new Gaulois("Obélix", 10);
		test = new Gaulois("test", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 10);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(ctrol, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertEquals(true, ctrol.isVendeur(obelix.getNom()));
		assertEquals(false, ctrol.isVendeur("Astérix"));
		assertEquals(false, ctrol.isVendeur("test"));
	}

	@Test
	void testLibererEtal() {
		assertTrue((ctrolEtalVendeur.trouverEtalVendeur(obelix.getNom()).etatEtal())[0].equals(String.valueOf(true)));
		ctrol.libererEtal(obelix.getNom());
		assertFalse((ctrolEtalVendeur.trouverEtalVendeur(obelix.getNom()).etatEtal())[0].equals(String.valueOf(true)));
	}

}

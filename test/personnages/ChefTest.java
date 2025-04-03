package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	Chef abraracourcix;
	Village village;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
	}

	@Test
	void testChef() {
		assertNotNull(abraracourcix);
	}
	
	@Test
	void prendreParole() {
		assertEquals("Le chef Abraracourcix du village le village des irréductibles : ", abraracourcix.prendreParole());
	}

}

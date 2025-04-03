package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class DruideTest {
	Chef abraracourcix;
	Village village;
	Druide panoramix;
	
	@BeforeEach
	void initConfig() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		panoramix = new Druide("Panoramix", 8, 5, 10);
	}

	@Test
	void testDruide() {
		assertNotNull(panoramix);
	}
}

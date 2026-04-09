package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ResourceBundle.Control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;


class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche controlAfficherMarche;
	
	@BeforeEach
	public void initiliserSit () {
		System.out.println("initialisation");
        village = new Village("le village des irréductibles", 10, 5);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testConstructeurControlAfficheMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche , "ne  renvoie pas null " );
	}
	
	
	@Test
	void testDonnerInfos() {
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		assertNotNull(infos, " donnerInfosMarche dois pas retourner null");
		
	}

}

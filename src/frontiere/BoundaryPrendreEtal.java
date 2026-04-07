package frontiere;

import java.awt.desktop.SystemEventListener;
// ajoué à demander si c possible 
import java.util.Scanner; 

import controleur.ControlEmmenager;
import controleur.ControlPrendreEtal;
import controleur.ControlPrendreEtal;
public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlEmmenagement;
	private Scanner scanner = new Scanner(System.in);


	public BoundaryPrendreEtal(ControlPrendreEtal controlEmmenagement) {
		this.controlEmmenagement = controlEmmenagement;
	}

	public void prendreEtal(String nomVendeur) {
	boolean nomVendeurConnu = ControlEmmenager.verifierIdentite(nomVendeur);
	if(!nomVendeurConnu) {
		System.out.println("je suis desole" +nomVendeur+ "mais il faut etre un habitant de notre village poiur commercer ici");
	}else 
		System.out.println("Bonjour" + nomVendeur + " je vais regarder si je peux vous  trouver un etal ");
	 boolean etalDisponible= controlEmmenagement.resteEtals();
	if(!etalDisponible) {
		System.out.println("Desole" + nomVendeur + " je n'eai plus d etal qui ne soit pas deja ocupé");	
	}else {
		System.out.println("c est parfaait il me reste un pour vs");
		System.out.println("il me raudras qlq renseignemetns");
		System.out.println("que produit souhaitez vous vendre?");
		String produit = scanner.nextLine();
		System.out.println("combien souhaitez vous en vendre ?");
		int  nbProduit = Integer.parseInt(scanner.nextLine());
		int numeroEtal = ControlEmmenager.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("le vendeur" + nomVendeur + " s est installe  al etal numero" +numeroEtal+ "\n");
		}
	}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}

package frontiere;

import controleur.ControlLibererEtal;
import controleur.ControlAfficherVillage;


public class BoundaryLibererEtal {
	private ControlLibererEtal controlAfficherVillage;

	public BoundaryLibererEtal(ControlLibererEtal controlAfficherVillage) {
		this.controlAfficherVillage = controlAfficherVillage;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = ControlAfficherVillage.isVendeur(nomVendeur);	
		if(!vendeurReconnu) {
			System.out.println("mais vs n etes pas sur notre marche");
		}else {
			 String [] donneesEtal = controlAfficherVillage.libererEtal(nomVendeur);
			 boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
		   if(etalOccupe) {
			   String quantiteVendu = donneesEtal[4];
			   String quantiteInitiale = donneesEtal[3];
			   String produit  = donneesEtal[2];
				System.out.println(" vous avez vendu" + quantiteVendu + "sur" + quantiteInitiale + "" +produit+ ".");	
			}
		   System.out.println("en revoir" +nomVendeur+ " passez une bonne journee ");
		}
		}

}

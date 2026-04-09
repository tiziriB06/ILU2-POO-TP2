package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
      String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
      if (infosMarche.length == 0 ) {
    	  System.out.println(" le marché est vide , revenez pls tard \n");
      }else {
    	  System.out.println(nomAcheteur+ "vous trouverz au marche \n");
    	  int i =0;
    	  while( i < infosMarche.length ) {
    		   String vendeur= infosMarche[i++];
    		   String quantite = infosMarche[i++];
    		   String produit = infosMarche[i++];
    		  System.out.println("-" + vendeur+ "qui vend" + quantite + "" +produit );
    	  }
      }
	}
}

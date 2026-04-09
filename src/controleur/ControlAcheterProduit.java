package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlVerifierIdentite controlVerifierIdentite;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
            ControlTrouverEtalVendeur controlTrouverEtalVendeur,
            Village village) {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public boolean verifierHabitant(String nom) {
        return controlVerifierIdentite.verifierIdentite(nom);
    }

    public String[] trouverVendeurs(String produit) {
        Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
        if (vendeurs == null) return null;
        String[] noms = new String[vendeurs.length];
        for (int i = 0; i < vendeurs.length; i++) {
            noms[i] = vendeurs[i].getNom();
        }
        return noms;
    }

    public String acheter(String nomAcheteur, String nomVendeur, int quantite) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        int stock = etal.getQuantite();

        if (stock == 0) {
            return nomAcheteur + " veut acheter " + quantite
                    + " " + etal.getProduit() + ", malheureusement il n'y en a plus !";
        } else if (stock < quantite) {
            etal.acheterProduit(stock);
            return nomAcheteur + " veut acheter " + quantite + " " + etal.getProduit()
                    + ", malheureusement " + nomVendeur + " n'en a plus que " + stock
                    + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".";
        } else {
            etal.acheterProduit(quantite);
            return nomAcheteur + " achète " + quantite
                    + " " + etal.getProduit() + " à " + nomVendeur;
        }
    }
}
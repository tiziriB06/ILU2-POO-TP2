package frontiere;

import controleur.ControlAcheterProduit;
import java.util.Scanner;

public class BoundaryAcheterProduit {
    private ControlAcheterProduit controlAcheterProduit;
    private static Scanner sc = new Scanner(System.in);

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        if (!controlAcheterProduit.verifierHabitant(nomAcheteur)) {
            System.out.println("Je suis désolée " + nomAcheteur
                    + " mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        System.out.println("Quel produit voulez-vous acheter ?");
        String produit = sc.nextLine();

        String[] vendeurs = controlAcheterProduit.trouverVendeurs(produit);
        if (vendeurs == null || vendeurs.length == 0) {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        for (int i = 0; i < vendeurs.length; i++) {
            String nomVendeur = vendeurs[i];
            if (!controlAcheterProduit.verifierHabitant(nomVendeur)) {
                System.out.println("Je suis désolée " + nomVendeur
                        + " mais il faut être un habitant de notre village pour commercer ici.");
                return;
            }
            System.out.println((i + 1) + " - " + nomVendeur);
        }

        int choix = Integer.parseInt(sc.nextLine());
        String nomVendeur = vendeurs[choix - 1];

        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
        System.out.println("Bonjour " + nomAcheteur);
        System.out.println("Combien de " + produit + " voulez-vous acheter ?");
        int quantite = Integer.parseInt(sc.nextLine());

        String resultat = controlAcheterProduit.acheter(nomAcheteur, nomVendeur, quantite);
        System.out.println(resultat);
    }
}
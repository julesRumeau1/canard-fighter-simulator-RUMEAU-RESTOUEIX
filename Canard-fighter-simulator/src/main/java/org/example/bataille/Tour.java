package org.example.bataille;

import org.example.canard.Canard;
import org.example.canard.Statut;

import java.util.Scanner;

public class Tour {
    private Canard attaquant;
    private Canard defenseur;
    private Scanner scanner;

    private int nbAttaque = 1;

    public Tour(Canard attaquant, Canard defenseur, Scanner scanner) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;
        this.scanner = scanner;
    }

    public void executer(Joueur joueur) {

        System.out.println("\n" + attaquant.getNom() + " attaque " + defenseur.getNom());

        if (attaquant.getCapaciteSpecialDisponible()) {
            System.out.println(joueur.getNom() + " : voulez-vous utiliser une capacité spéciale ? (oui/non)");
            String reponse = scanner.nextLine().toLowerCase();
            if (reponse.equals("oui")) {
                attaquant.activerCapaciteSpeciale(defenseur);
            }
        }
        if (attaquant.statut == Statut.BOOST_ATTAQUE) {
            nbAttaque = 2;
        }

        for (int i = 0; i < nbAttaque; i++) {
            attaquant.attaquer(defenseur);
        }
        attaquant.statut = Statut.NORMAL;

    }
}
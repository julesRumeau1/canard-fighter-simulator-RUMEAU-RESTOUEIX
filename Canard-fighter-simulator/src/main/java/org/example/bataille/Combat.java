package org.example.bataille;

import org.example.canard.Canard;
import org.example.canard.Statut;

import java.util.List;
import java.util.Scanner;

public class Combat {
    private Canard canard1;
    private Canard canard2;
    private Scanner scanner;
    private Joueur joueur1;
    private Joueur joueur2;

    public Combat(Scanner scanner, List<Joueur> joueurs, List<Canard> canards) {
        this.scanner = scanner;

        System.out.println("Sélectionnez les numéros des deux joueurs :");
        for (int i = 0; i < joueurs.size(); i++) {
            System.out.println((i + 1) + ". " + joueurs.get(i).getNom() +
                    " (" + joueurs.get(i).getPotions() + " Potions )");
        }
        System.out.print("Joueur 1 : ");
        int indexJ1 = scanner.nextInt() - 1;
        System.out.print("Joueur 2 : ");
        int indexJ2 = scanner.nextInt() - 1;

        this.joueur1 = joueurs.get(indexJ1);
        this.joueur2 = joueurs.get(indexJ2);
        scanner.nextLine();

        System.out.println("Sélectionnez les numéros des deux canards combattants :");
        for (int i = 0; i < canards.size(); i++) {
            System.out.println((i + 1) + ". " + canards.get(i).getNom() +
                    " (" + canards.get(i).getType() + ", " + canards.get(i).getPointsDeVie() +
                    "HP , " + canards.get(i).getPointsAttaque() + "PA)");
        }
        System.out.print(joueur1.getNom() + " -> Canard : ");
        int index1 = scanner.nextInt() - 1;
        System.out.print(joueur2.getNom() + " -> Canard : ");
        int index2 = scanner.nextInt() - 1;

        this.canard1 = canards.get(index1);
        this.canard2 = canards.get(index2);
        scanner.nextLine();

    }

    public void demarrer() {
        this.scanner = scanner;

        System.out.println("Début du combat entre " + joueur1.getNom() + " et " + joueur2.getNom() + "!\n");
        System.out.println(joueur1.getNom() + " lance " + canard1.getNom());
        System.out.println(joueur2.getNom() + " lance " + canard2.getNom());

        double pvCanard1 = canard1.getPointsDeVie();
        double pvCanard2 = canard2.getPointsDeVie();
        while (!canard1.estKO() && !canard2.estKO()) {

            System.out.println("==================================");
            System.out.println("========== NOUVEAU TOUR ==========");
            System.out.println("==================================");

            tourJoueur(joueur1, canard1, canard2);
            tourJoueur(joueur2, canard2, canard1);

            System.out.println("\n" + canard1.getNom() + " : " + canard1.getPointsDeVie() + "PV");
            System.out.println(canard2.getNom() + " : " + canard2.getPointsDeVie() + "PV\n");
        }

        // fin du combat on restaure les pv
        canard1.setPointsDeVie(pvCanard1);
        canard2.setPointsDeVie(pvCanard2);
        canard1.setCapaciteSpecialDisponible(true);
        canard2.setCapaciteSpecialDisponible(true);

        if (canard1.estKO()) {
            System.out.println(canard1.getNom() + " est K.O ! " + canard2.getNom() + " gagne !");
            canard2.genererBonus();
        } else {
            System.out.println(canard2.getNom() + " est K.O ! " + canard1.getNom() + " gagne !");
            canard1.genererBonus();
        }


    }
    
    private void tourJoueur(Joueur joueur, Canard canardAttaquant, Canard canardDefenseur) {

        if (joueur.getPotions() > 0) {
            System.out.println(joueur.getNom() + " veux-tu utiliser une potion ?");
            String reponse = scanner.nextLine().toLowerCase();
            if (reponse.equals("oui")) {
                joueur.utiliserPotion(canardAttaquant);
            }
        }
        attaque(joueur, canardAttaquant, canardDefenseur);
    }


    private void attaque(Joueur joueur, Canard attanquant, Canard cible) {
        if (attanquant.estGele()) {
            attanquant.statut = Statut.NORMAL;
            return;
        }

        if (cible.estKO()) {
            return;
        }

        Tour tour = new Tour(attanquant, cible, scanner);
        tour.executer(joueur);

    }
}

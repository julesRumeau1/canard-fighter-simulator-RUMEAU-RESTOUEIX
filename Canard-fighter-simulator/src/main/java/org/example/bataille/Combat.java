package org.example.bataille;

import org.example.canard.Canard;
import org.example.canard.Statut;

import java.util.List;
import java.util.Scanner;

public class Combat {
    private Canard canard1;
    private Canard canard2;
    private Scanner scanner;

    public Combat(Scanner scanner, List<Canard> canards) {
        this.scanner = scanner;
        System.out.println("Sélectionnez les deux canards combattants :");
        for (int i = 0; i < canards.size(); i++) {
            System.out.println((i + 1) + ". " + canards.get(i).getNom() + "(" + canards.get(i).getType() + ")");
        }
        System.out.print("Canard 1 : ");
        int index1 = scanner.nextInt() - 1;
        System.out.print("Canard 2 : ");
        int index2 = scanner.nextInt() - 1;

        this.canard1 = canards.get(index1);
        this.canard2 = canards.get(index2);
    }

    public void demarrer() {
        System.out.println("Début du combat entre " + canard1.getNom() + " et " + canard2.getNom() + "!");

        while (!canard1.estKO() && !canard2.estKO()) {
            if (!canard1.estGele()) {
                Tour tour = new Tour(canard1, canard2, scanner);
                tour.executer();
            } else {
                System.out.println(canard1.getNom() + " est gelé et ne peut pas attaquer !");
                canard1.statut = Statut.NORMAL;
            }

            if (!canard2.estKO() && !canard2.estGele()) {
                Tour tourInverse = new Tour(canard2, canard1, scanner);
                tourInverse.executer();
            } else if (canard2.estGele()) {
                System.out.println(canard2.getNom() + " est gelé et ne peut pas attaquer !");
                canard2.statut = Statut.NORMAL;
            }

            System.out.println("\n" + canard1.getNom() + " : " + canard1.getPointsDeVie());
            System.out.println(canard2.getNom() + " : " + canard2.getPointsDeVie() + "\n");
        }

        if (canard1.estKO()) {
            System.out.println(canard1.getNom() + " est K.O ! " + canard2.getNom() + " gagne !");
        } else {
            System.out.println(canard2.getNom() + " est K.O ! " + canard1.getNom() + " gagne !");
        }
    }
}

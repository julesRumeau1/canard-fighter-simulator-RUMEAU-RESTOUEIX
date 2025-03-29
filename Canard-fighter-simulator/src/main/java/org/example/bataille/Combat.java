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
        scanner.nextLine(); // vider le buffer après nextInt()

    }

    public void demarrer() {
        System.out.println("Début du combat entre " + canard1.getNom() + " et " + canard2.getNom() + "!");


        while (!canard1.estKO() && !canard2.estKO()) {


            attaque(canard1, canard2);
            attaque(canard2, canard1);

            System.out.println("\n" + canard1.getNom() + " : " + canard1.getPointsDeVie());
            System.out.println(canard2.getNom() + " : " + canard2.getPointsDeVie() + "\n");
        }

        if (canard1.estKO()) {
            System.out.println(canard1.getNom() + " est K.O ! " + canard2.getNom() + " gagne !");
        } else {
            System.out.println(canard2.getNom() + " est K.O ! " + canard1.getNom() + " gagne !");
        }
    }


    private void attaque(Canard attanquant, Canard cible) {
        if (attanquant.estGele()) {
            attanquant.statut = Statut.NORMAL;
            return;
        }

        if (cible.estKO()) {
            return;
        }

        Tour tour = new Tour(attanquant, cible, scanner);
        tour.executer();

    }
}

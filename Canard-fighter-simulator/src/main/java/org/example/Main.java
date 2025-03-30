package org.example;

import org.example.bataille.Combat;
import org.example.canard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int pvDefaut = 100;
    private static int attaqueDefaut = 10;
    private static int pvMax = 200;
    private static int pointAttaqueMax = 20;

    public static Canard creerCanard(String nom, int type, int pv, int pa) {

        if (pv > pvMax) {
            pv = pvMax;
        } else if (pv <= 0) {
            pv = pvDefaut;
        }

        if (pa > pointAttaqueMax) {
            pa = pointAttaqueMax;
        } else if (pa <= 0) {
            pa = attaqueDefaut;
        }

        switch (type) {
            case 1:
                CanardEau canardEau = new CanardEau(nom, TypeCanard.values()[type - 1], pv, pa);
                return canardEau;
            case 2:
                CanardFeu CanardFeu = new CanardFeu(nom, TypeCanard.values()[type - 1], pv, pa);
                return CanardFeu;
            case 3:
                CanardGlace CanardGlace = new CanardGlace(nom, TypeCanard.values()[type - 1], pv, pa);
                return CanardGlace;
            case 4:
                CanardVent CanardVent = new CanardVent(nom, TypeCanard.values()[type - 1], pv, pa);
                return CanardVent;
            default:
                System.out.println("Création impossible");
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Canard> listCanard = new ArrayList<>();

        while (true) {
            System.out.println("Bienvenue dans Canard Fighter Simulator !");
            System.out.println("1. Créer un canard");
            System.out.println("2. Lancer une bataille");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom du canard : ");
                    String nom = scanner.nextLine();
                    System.out.println("Choisissez un type : 1. Eau, 2. Feu, 3. Glace, 4. Vent");
                    int typeChoix = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Choisissez le nombre de points de vie");
                    int nbPV = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Choisissez les points d'attaque");
                    int nbPA = scanner.nextInt();
                    scanner.nextLine();

                    Canard canard = creerCanard(nom, typeChoix, nbPV, nbPA);
                    listCanard.add(canard);
                    System.out.println("Canard créé avec succès !");
                    break;
                case 2:
                    if (listCanard.size() < 2) {
                        System.out.println("Il faut au moins deux canards pour combattre !");
                    } else {
                        Combat combat = new Combat(scanner, listCanard);
                        combat.demarrer();
                    }
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }
    }
}
package org.example;

import org.example.canard.Canard;
import org.example.canard.TypeCanard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                    TypeCanard type = TypeCanard.values()[typeChoix - 1];
                    Canard canard = new Canard(nom, type, 100, 10);
                    listCanard.add(canard);
                    System.out.println("Canard créé");
                    break;
                case 2:
                    if (listCanard.size() < 2) {
                        System.out.println("Il faut au moins deux canards pour combattre !");
                    } else {
                        // lancerBataille
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
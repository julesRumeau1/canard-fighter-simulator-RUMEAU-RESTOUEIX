package org.example;

import org.example.bataille.Combat;
import org.example.bataille.Joueur;
import org.example.canard.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * Points de vie par défaut pour un canard.
     */
    private final static int PV_DEFAUT = 100;

    /**
     * Points d'attaque par défaut pour un canard.
     */
    private final static int POINTS_ATTAQUE_DEFAUT = 10;

    /**
     * Points de vie maximum pour un canard.
     */
    private final static int PV_MAX = 200;

    /**
     * Points d'attaque maximum pour un canard.
     */
    private final static int POINTS_ATTAQUE_MAX = 20;

    /**
     * Crée un canard en fonction du type, nom, points de vie et points d'attaque.
     *
     * @param nom Le nom du canard.
     * @param type Le type du canard (1: Eau, 2: Feu, 3: Glace, 4: Vent).
     * @param pv Les points de vie du canard.
     * @param pa Les points d'attaque du canard.
     * @return Le canard créé.
     */
    public static Canard creerCanard(String nom, int type, int pv, int pa) {

        if (pv > PV_MAX) {
            pv = PV_MAX;
        } else if (pv <= 0) {
            pv = PV_DEFAUT;
        }

        if (pa > POINTS_ATTAQUE_MAX) {
            pa = POINTS_ATTAQUE_MAX;
        } else if (pa <= 0) {
            pa = POINTS_ATTAQUE_DEFAUT;
        }

        switch (type) {
            case 1:
                CanardEau canardEau = new CanardEau(nom, TypeCanard.values()[type - 1], pv, pa);
                return canardEau;
            case 2:
                CanardFeu canardFeu = new CanardFeu(nom, TypeCanard.values()[type - 1], pv, pa);
                return canardFeu;
            case 3:
                CanardGlace canardGlace = new CanardGlace(nom, TypeCanard.values()[type - 1], pv, pa);
                return canardGlace;
            case 4:
                CanardVent canardVent = new CanardVent(nom, TypeCanard.values()[type - 1], pv, pa);
                return canardVent;
            default:
                System.out.println("Création impossible");
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Canard> listCanard = new ArrayList<>();
        List<Joueur> listJoueur = new ArrayList<>();
        Random random = new Random();

        while (true) {
            System.out.println("Bienvenue dans Canard Fighter Simulator !");
            System.out.println("1. Créer un joueur");
            System.out.println("2. Créer un canard");
            System.out.println("3. Lancer une bataille");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom du joueur : ");
                    String nomJoueur = scanner.nextLine();

                    int nbPotion = random.nextInt(6);
                    System.out.println(nomJoueur + " aura " + nbPotion + " potion(s)");

                    Joueur joueur = new Joueur(nomJoueur, nbPotion);
                    listJoueur.add(joueur);
                    break;

                case 2:
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
                case 3:
                    if (listCanard.size() < 2) {
                        System.out.println("Il faut au moins deux canards pour combattre !");
                    } else if (listJoueur.size() < 2) {
                        System.out.println("Il faut au moins deux joueurs pour combattre !");
                    } else {
                        Combat combat = new Combat(scanner, listJoueur, listCanard);
                        combat.demarrer();
                    }
                    break;
                case 4:
                    System.out.println("Merci d'avoir joué !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }
    }
}
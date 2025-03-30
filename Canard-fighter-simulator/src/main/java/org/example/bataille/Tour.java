package org.example.bataille;

import org.example.canard.Canard;
import org.example.canard.Statut;
import org.example.capaciteSpeciale.CapaciteSpeciale;

import java.util.Scanner;

/**
 * Représente un tour de combat où un canard attaque un autre.
 * Gère l'activation des capacités spéciales et les attaques.
 */
public class Tour {
    /**
     * Le canard qui attaque.
     */
    private Canard attaquant;

    /**
     * Le canard qui reçoit l'attaque.
     */
    private Canard defenseur;

    /**
     * Le scanner pour lire les entrées du joueur.
     */
    private Scanner scanner;

    /**
     * Le nombre d'attaques que l'attaquant peut effectuer dans ce tour.
     * Par défaut, 1 attaque par tour.
     */
    private int nbAttaque = 1;

    /**
     * Constructeur pour initialiser un tour de combat.
     *
     * @param attaquant Le canard qui attaque.
     * @param defenseur Le canard qui reçoit l'attaque.
     * @param scanner Le scanner pour lire les entrées du joueur.
     */
    public Tour(Canard attaquant, Canard defenseur, Scanner scanner) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;
        this.scanner = scanner;
    }

    /**
     * Exécute le tour de combat en permettant à l'attaquant d'attaquer le défenseur.
     * Offre la possibilité au joueur d'utiliser une capacité spéciale.
     *
     * @param joueur Le joueur qui contrôle l'attaquant.
     */
    public void executer(Joueur joueur) {

        // Affiche le message d'attaque
        System.out.println("\n" + attaquant.getNom() + " attaque " + defenseur.getNom());

        // Si l'attaquant a une capacité spéciale disponible, on demande au joueur s'il veut l'utiliser
        if (attaquant.getCapaciteSpecialDisponible()) {
            System.out.println(joueur.getNom() + " : voulez-vous utiliser une capacité spéciale ? (oui/non)");
            String reponse = scanner.nextLine().toLowerCase();
            if (reponse.equals("oui")) {
                // Si le joueur accepte, on lui permet de choisir la capacité spéciale à utiliser
                int indexCapaciteSpeciale = choixCapaciteSpeciale(attaquant);
                // Activation de la capacité spéciale choisie
                attaquant.activerCapaciteSpeciale(defenseur, indexCapaciteSpeciale);
            }
        }

        // Si l'attaquant a le statut "BOOST_ATTAQUE", il attaque deux fois
        if (attaquant.statut == Statut.BOOST_ATTAQUE) {
            nbAttaque = 2;
        }

        // Effectue l'attaque
        for (int i = 0; i < nbAttaque; i++) {
            attaquant.attaquer(defenseur);
        }

        // Restaure le statut de l'attaquant à NORMAL après l'attaque
        attaquant.statut = Statut.NORMAL;
    }

    /**
     * Permet au joueur de choisir une capacité spéciale parmi celles disponibles pour l'attaquant.
     *
     * @param attaquant Le canard qui attaque.
     * @return L'indice de la capacité spéciale choisie.
     */
    private int choixCapaciteSpeciale(Canard attaquant) {
        // Affiche la liste des capacités spéciales disponibles
        System.out.println("Sélectionnez une capacité spéciale :");

        int i = 1;
        // Affiche chaque capacité spéciale avec son indice
        for (CapaciteSpeciale capaciteSpeciale: attaquant.getCapacitesSpeciales()) {
            System.out.println(i + ". " + capaciteSpeciale.getLibelle());
            i++;
        }

        // Lit l'entrée du joueur pour choisir la capacité spéciale
        int index = scanner.nextInt() - 1;
        try {
            // Vérifie si la capacité spéciale existe
            attaquant.getCapaciteSpeciale(index);
        } catch (Exception e) {
            // Si une erreur se produit, on invite le joueur à réessayer
            System.out.println("Une erreur est survenue, veuillez réessayer.");
            choixCapaciteSpeciale(attaquant);
        }
        scanner.nextLine(); // Vider le buffer après nextInt()
        return index;
    }
}

package org.example.bataille;

import org.example.canard.Canard;

/**
 * Représente un joueur qui possède un nom et un nombre de potions.
 * Le joueur peut utiliser une potion pour soigner un canard.
 */
public class Joueur {
    /**
     * Le nom du joueur.
     */
    private String nom;

    /**
     * Le nombre de potions que le joueur possède. Par défaut, 1 potion.
     */
    private int potions = 1;

    /**
     * Constructeur pour initialiser un joueur avec un nom et un nombre initial de potions.
     *
     * @param nom Le nom du joueur.
     * @param potionsInitiales Le nombre initial de potions du joueur.
     */
    public Joueur(String nom, int potionsInitiales) {
        this.nom = nom;
        this.potions = Math.max(potionsInitiales, 0); // Évite un nombre négatif de potions
    }

    /**
     * Utilise une potion pour soigner un canard, augmentant ses points de vie.
     * Réduit également le nombre de potions disponibles.
     *
     * @param canard Le canard à soigner.
     */
    public void utiliserPotion(Canard canard) {
        // Augmente les points de vie du canard de 20
        canard.setPointsDeVie(canard.getPointsDeVie() + 20);

        // Réduit le nombre de potions du joueur
        potions--;
        System.out.println(nom + " a utilisé une potion. Potions restantes: " + potions);
    }

    /**
     * Obtient le nombre de potions restantes.
     *
     * @return Le nombre de potions restantes.
     */
    public int getPotions() {
        return potions;
    }

    /**
     * Obtient le nom du joueur.
     *
     * @return Le nom du joueur.
     */
    public String getNom() {
        return nom;
    }
}

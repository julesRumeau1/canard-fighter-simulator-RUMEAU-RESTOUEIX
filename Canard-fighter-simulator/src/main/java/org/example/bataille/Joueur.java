package org.example.bataille;

import org.example.canard.Canard;

public class Joueur {
    private String nom;
    private int potions = 1;

    public Joueur(String nom, int potionsInitiales) {
        this.nom = nom;
        this.potions = Math.max(potionsInitiales, 0); // Évite un nombre négatif de potions
    }

    public void utiliserPotion(Canard canard) {
        canard.setPointsDeVie(canard.getPointsDeVie()+20);
        potions--;
        System.out.println(nom + " a utilisé une potion. Potions restantes: " + potions);
    }

    public int getPotions() {
        return potions;
    }

    public String getNom() {
        return nom;
    }
}

package org.example.canard;

import org.example.capaciteSpeciale.CapaciteFlamme;

/**
 * Classe représentant un canard de type Feu.
 * Ce canard possède la capacité spéciale "Flamme", qui lui permet d'augmenter ses dégâts pendant un certain temps.
 */
public class CanardFeu extends Canard {

    /**
     * Constructeur du canard de type Feu.
     *
     * @param nom          Le nom du canard.
     * @param type         Le type du canard (doit être {@link TypeCanard#Feu}).
     * @param pointsDeVie  Les points de vie du canard.
     * @param pointsAttaque Les points d'attaque du canard.
     */
    public CanardFeu(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteFlamme());
    }
}

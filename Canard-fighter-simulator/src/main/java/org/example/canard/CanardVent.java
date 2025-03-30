package org.example.canard;

import org.example.capaciteSpeciale.CapaciteRafale;

/**
 * Classe représentant un canard de type Vent.
 * Ce canard possède la capacité spéciale "Rafale", qui lui permet d'attaquer plus rapidement.
 */
public class CanardVent extends Canard {

    /**
     * Constructeur du canard de type Vent.
     *
     * @param nom         Le nom du canard.
     * @param type        Le type du canard (doit être {@link TypeCanard#Vent}).
     * @param pointsDeVie Les points de vie du canard.
     * @param pointsAttaque Les points d'attaque du canard.
     */
    public CanardVent(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteRafale());
    }
}

package org.example.canard;

import org.example.capaciteSpeciale.CapaciteGel;

/**
 * Classe représentant un canard de type Glace.
 * Ce canard possède la capacité spéciale "Gel", qui lui permet de geler un adversaire et de l'empêcher d'attaquer pendant un tour.
 */
public class CanardGlace extends Canard {

    /**
     * Constructeur du canard de type Glace.
     *
     * @param nom          Le nom du canard.
     * @param type         Le type du canard (doit être {@link TypeCanard#Glace}).
     * @param pointsDeVie  Les points de vie du canard.
     * @param pointsAttaque Les points d'attaque du canard.
     */
    public CanardGlace(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteGel());
    }
}

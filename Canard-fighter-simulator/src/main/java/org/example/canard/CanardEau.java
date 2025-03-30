package org.example.canard;

import org.example.capaciteSpeciale.CapaciteRegeneration;

/**
 * Classe représentant un canard de type Eau.
 * Ce canard possède la capacité spéciale "Régénération", qui lui permet de récupérer des points de vie.
 */
public class CanardEau extends Canard {

    /**
     * Constructeur du canard de type Eau.
     *
     * @param nom          Le nom du canard.
     * @param type         Le type du canard (doit être {@link TypeCanard#Eau}).
     * @param pointsDeVie  Les points de vie du canard.
     * @param pointsAttaque Les points d'attaque du canard.
     */
    public CanardEau(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteRegeneration());
    }
}

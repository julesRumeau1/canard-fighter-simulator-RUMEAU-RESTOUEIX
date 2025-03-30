package org.example.canard;

import org.example.capaciteSpeciale.CapaciteFlamme;
import org.example.capaciteSpeciale.CapaciteGel;

public class CanardGlace extends Canard {

    public CanardGlace(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteGel());
    }
}

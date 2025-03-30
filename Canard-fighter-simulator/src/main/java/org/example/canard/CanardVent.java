package org.example.canard;

import org.example.capaciteSpeciale.CapaciteGel;
import org.example.capaciteSpeciale.CapaciteRafale;

public class CanardVent extends Canard{

    public CanardVent(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
        ajouterCapaciteSpeciale(new CapaciteRafale());
    }
}

package org.example.canard;

import org.example.capaciteSpeciale.CapaciteRegeneration;

public class CanardEau extends Canard {

    public CanardEau(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque, new CapaciteRegeneration());
    }
}

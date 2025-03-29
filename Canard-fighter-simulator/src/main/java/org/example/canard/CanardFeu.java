package org.example.canard;

import org.example.capaciteSpeciale.CapaciteFlamme;

public class CanardFeu extends Canard{

    public CanardFeu(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque, new CapaciteFlamme());
    }
}

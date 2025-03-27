package org.example.canard;

public class CanardVent extends Canard{

    public CanardVent(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(){
    }
}

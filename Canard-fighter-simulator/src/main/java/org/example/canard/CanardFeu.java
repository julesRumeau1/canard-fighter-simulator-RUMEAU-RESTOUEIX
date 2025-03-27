package org.example.canard;

public class CanardFeu extends Canard{

    public CanardFeu(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(){
    }
}

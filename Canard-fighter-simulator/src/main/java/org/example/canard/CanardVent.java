package org.example.canard;

public class CanardVent extends Canard{

    public CanardVent(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(){
        capaciteSpecialeGlace();
    }

    private void capaciteSpecialeGlace() {
        // TODO augmente temporairement sa vitesse d’attaque (2x attaque,
        // 3x attaque, etc.).
    }

}

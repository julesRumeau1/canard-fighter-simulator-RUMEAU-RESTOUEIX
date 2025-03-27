package org.example.canard;

public class CanardGlace extends Canard {

    public CanardGlace(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(){
        capaciteSpecialeGlace();
    }
    private void capaciteSpecialeGlace() {
        // TODO gèle un adversaire, lui faisant perdre un tour
    }

}

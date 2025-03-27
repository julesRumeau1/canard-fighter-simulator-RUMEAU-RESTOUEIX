package org.example.canard;

public class CanardEau extends Canard {

    public CanardEau(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(){
        capaciteSpecialeEau();
    }
    private void capaciteSpecialeEau() {
        // régénère 20 pv
        this.setPointsDeVie(this.getPointsDeVie() + 20);
    }
}

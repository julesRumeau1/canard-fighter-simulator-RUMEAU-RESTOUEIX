package org.example.canard;

public class CanardGlace extends Canard {

    public CanardGlace(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible){
        capaciteSpecialeGlace(cible);
    }
    private void capaciteSpecialeGlace(Canard cible) {
        // a gelé l'adversaire
        cible.statut = Statut.GEL;
        this.capaciteSpecial = false;
    }

}

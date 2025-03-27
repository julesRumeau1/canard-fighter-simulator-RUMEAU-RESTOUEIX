package org.example.canard;

public class CanardFeu extends Canard{

    public CanardFeu(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        super(nom, type, pointsDeVie, pointsAttaque);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible){
        capaciteSpecialeFeu();
    }

    private void capaciteSpecialeFeu() {
        // fera en sorte de doublé les dégats lors de la prochaine attaque
        this.statut = Statut.AUGMENTATION_DEGATS;
        this.capaciteSpecial = false;
    }

}

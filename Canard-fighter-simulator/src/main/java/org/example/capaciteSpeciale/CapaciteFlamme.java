package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

public class CapaciteFlamme implements CapaciteSpeciale {
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " s'embrase et inflige des dégâts supplémentaires !");
        utilisateur.setStatut(Statut.AUGMENTATION_DEGATS);
        utilisateur.setCapaciteSpecialDisponible(false);
    }
    public String getLibelle() {
        return "Flamme";
    }
}

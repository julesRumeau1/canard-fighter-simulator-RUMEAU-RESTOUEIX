package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

public class CapaciteRafale implements CapaciteSpeciale {
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " devient plus rapide et attaque plus souvent !");
        utilisateur.setStatut(Statut.VITESSE_AUGMENTEE);
        utilisateur.setCapaciteSpecialDisponible(false);
    }
    public String getLibelle() {
        return "Rafale";
    }
}
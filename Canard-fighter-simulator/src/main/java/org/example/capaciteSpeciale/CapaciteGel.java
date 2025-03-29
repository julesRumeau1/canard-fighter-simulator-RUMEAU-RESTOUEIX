package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

public class CapaciteGel implements CapaciteSpeciale {
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " gèle " + cible.getNom() + ", il ne pourra pas attaquer ce tour !");
        cible.setStatut(Statut.GEL);
        utilisateur.setCapaciteSpecial(false);
    }
}
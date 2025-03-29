package org.example.capaciteSpeciale;

import org.example.canard.Canard;

public class CapaciteRegeneration implements CapaciteSpeciale {
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " utilise Régénération et récupère 20 PV !");
        utilisateur.setPointsDeVie(utilisateur.getPointsDeVie() + 20);
        utilisateur.setCapaciteSpecial(false);
    }
}

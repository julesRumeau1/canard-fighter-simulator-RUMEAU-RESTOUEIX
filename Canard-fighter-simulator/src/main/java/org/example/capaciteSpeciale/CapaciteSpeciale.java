package org.example.capaciteSpeciale;

import org.example.canard.Canard;

public interface CapaciteSpeciale {
    String getLibelle();
    void activer(Canard utilisateur, Canard cible);
}


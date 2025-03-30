package org.example.capaciteSpeciale;

import org.example.canard.Canard;

/**
 * Représente une capacité spéciale qu'un canard peut utiliser en combat.
 */
public interface CapaciteSpeciale {

    /**
     * Retourne le libellé de la capacité.
     *
     * @return Nom de la capacité spéciale.
     */
    String getLibelle();

    /**
     * Active la capacité spéciale sur une cible.
     *
     * @param utilisateur Le canard qui utilise la capacité.
     * @param cible       Le canard adverse ciblé (ou null si la capacité ne cible personne).
     */
    void activer(Canard utilisateur, Canard cible);
}

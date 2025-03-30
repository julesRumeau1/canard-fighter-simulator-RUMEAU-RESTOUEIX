package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

/**
 * Capacité spéciale permettant à un canard de geler un adversaire,
 * l'empêchant d'attaquer pendant un tour.
 */
public class CapaciteGel implements CapaciteSpeciale {

    /**
     * Active la capacité Gel, appliquant le statut "Gel" à la cible.
     *
     * @param utilisateur Le canard qui utilise la capacité.
     * @param cible       Le canard adverse qui sera gelé.
     */
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " gèle " + cible.getNom() + ", il ne pourra pas attaquer ce tour !");
        cible.setStatut(Statut.GEL);
        utilisateur.setCapaciteSpecialDisponible(false);
    }

    /**
     * Retourne le nom de la capacité.
     *
     * @return "Gel".
     */
    @Override
    public String getLibelle() {
        return "Gel";
    }
}

package org.example.capaciteSpeciale;

import org.example.canard.Canard;

/**
 * Capacité spéciale permettant à un canard de récupérer des points de vie.
 */
public class CapaciteRegeneration implements CapaciteSpeciale {

    /**
     * Active la capacité de régénération, restaurant 20 PV à l'utilisateur.
     *
     * @param utilisateur Le canard qui utilise la capacité.
     * @param cible       Ignoré dans cette capacité (régénération personnelle).
     */
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " utilise " + getLibelle() + " et récupère 20 PV !");
        utilisateur.setPointsDeVie(utilisateur.getPointsDeVie() + 20);
        utilisateur.setCapaciteSpecialDisponible(false);
    }

    /**
     * Retourne le nom de la capacité.
     *
     * @return "Régénération".
     */
    @Override
    public String getLibelle() {
        return "Régénération";
    }
}

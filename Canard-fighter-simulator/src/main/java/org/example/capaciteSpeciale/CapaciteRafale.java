package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

/**
 * Capacité spéciale permettant à un canard d'augmenter temporairement sa vitesse d'attaque.
 */
public class CapaciteRafale implements CapaciteSpeciale {

    /**
     * Active la capacité Rafale, augmentant la vitesse d'attaque du canard.
     *
     * @param utilisateur Le canard qui utilise la capacité.
     * @param cible       Ignoré dans cette capacité (effet personnel).
     */
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " devient plus rapide et attaque plus souvent !");
        utilisateur.setStatut(Statut.VITESSE_AUGMENTEE);
        utilisateur.setCapaciteSpecialDisponible(false);
    }

    /**
     * Retourne le nom de la capacité.
     *
     * @return "Rafale".
     */
    @Override
    public String getLibelle() {
        return "Rafale";
    }
}

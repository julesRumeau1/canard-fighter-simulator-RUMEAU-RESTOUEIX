package org.example.capaciteSpeciale;

import org.example.canard.Canard;
import org.example.canard.Statut;

/**
 * Capacité spéciale permettant à un canard d'augmenter temporairement ses dégâts.
 */
public class CapaciteFlamme implements CapaciteSpeciale {

    /**
     * Active la capacité Flamme, augmentant les dégâts du canard pour le prochain tour.
     *
     * @param utilisateur Le canard qui utilise la capacité.
     * @param cible       Le canard adverse (non utilisé ici, mais maintenu pour cohérence).
     */
    @Override
    public void activer(Canard utilisateur, Canard cible) {
        System.out.println(utilisateur.getNom() + " s'embrase et inflige des dégâts supplémentaires !");
        utilisateur.setStatut(Statut.AUGMENTATION_DEGATS);
        utilisateur.setCapaciteSpecialDisponible(false);
    }

    /**
     * Retourne le nom de la capacité.
     *
     * @return "Flamme".
     */
    @Override
    public String getLibelle() {
        return "Flamme";
    }
}

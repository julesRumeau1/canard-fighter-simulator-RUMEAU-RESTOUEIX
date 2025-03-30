package org.example.canard;

/**
 * Enumération représentant les différents statuts qu'un canard peut avoir en combat.
 */
public enum Statut {
    /** Statut par défaut, le canard agit normalement. */
    NORMAL,

    /** Le canard est gelé et ne peut pas attaquer pendant un tour. */
    GEL,

    /** Augmente temporairement l'attaque du canard. */
    BOOST_ATTAQUE,

    /** Le canard inflige des dégâts supplémentaires. */
    AUGMENTATION_DEGATS,

    /** Le canard attaque plus rapidement pendant un certain temps. */
    VITESSE_AUGMENTEE
}

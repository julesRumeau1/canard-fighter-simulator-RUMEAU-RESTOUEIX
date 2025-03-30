package org.example.canard;

/**
 * Enumération représentant les différents types de canards et leurs interactions élémentaires.
 */
public enum TypeCanard {
    Eau, Feu, Glace, Vent;

    /**
     * Calcule le multiplicateur de dégâts en fonction du type de l'attaquant et du type de la cible.
     *
     * @param attaquant Le type du canard attaquant.
     * @param cible     Le type du canard ciblé.
     * @return Un multiplicateur de dégâts (1.5 si l'attaque est forte, 0.5 si elle est faible, 1.0 sinon).
     */
    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        final double fort = 1.5;
        final double faible = 0.5;
        final double neutre = 1.0;

        if ((attaquant == Eau && cible == Feu) ||
                (attaquant == Feu && cible == Glace) ||
                (attaquant == Glace && cible == Vent) ||
                (attaquant == Vent && cible == Eau)) {
            return fort;
        }
        if ((attaquant == Feu && cible == Eau) ||
                (attaquant == Glace && cible == Feu) ||
                (attaquant == Vent && cible == Glace) ||
                (attaquant == Eau && cible == Vent)) {
            return faible;
        }

        return neutre;
    }
}

package org.example.canard;

public enum TypeCanard {
    Eau, Feu, Glace, Vent;
    public static double getMultiplicateurr(TypeCanard attaquant, TypeCanard cible) {

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


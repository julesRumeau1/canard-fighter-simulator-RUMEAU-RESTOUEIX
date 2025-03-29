package org.example.canard;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanardTest {
    private Canard canardEau;
    private Canard canardFeu;
    private Canard canardGlace;
    private Canard canardVent;

    @BeforeEach
    void setUp() {
        canardEau = new CanardFeu("AquaDuck", TypeCanard.Eau, 100, 20);
        canardFeu = new CanardFeu("FlameDuck", TypeCanard.Feu, 100, 20);
        canardGlace = new CanardFeu("IceDuck", TypeCanard.Glace, 100, 20);
        canardVent = new CanardFeu("WindDuck", TypeCanard.Vent, 100, 20);
    }

    @Test
    void testAttaqueAvecMultiplicateurFort() {
        canardEau.attaquer(canardFeu);  // Eau > Feu
        assertEquals(100 - (20 * 1.5), canardFeu.getPointsDeVie());
    }

    @Test
    void testAttaqueAvecMultiplicateurFaible() {
        canardFeu.attaquer(canardEau);  // Feu < Eau
        assertEquals(100 - (20 * 0.5), canardEau.getPointsDeVie());
    }

    @Test
    void testAttaqueAvecMultiplicateurNeutre() {
        canardEau.attaquer(canardGlace);  // Eau vs Glace = neutre
        assertEquals(100 - (20 * 1.0), canardGlace.getPointsDeVie());
    }

    @Test
    void testCanardDevientKO() {
        Canard canardFaible = new CanardFeu("WeakDuck", TypeCanard.Feu, 10, 20);
        canardEau.attaquer(canardFaible);  // Eau > Feu, 30 dégâts
        assertTrue(canardFaible.estKO());
    }

    @Test
    void testCanardSurvit() {
        canardFeu.attaquer(canardEau);  // Feu < Eau, 10 dégâts
        assertFalse(canardEau.estKO());
    }
}

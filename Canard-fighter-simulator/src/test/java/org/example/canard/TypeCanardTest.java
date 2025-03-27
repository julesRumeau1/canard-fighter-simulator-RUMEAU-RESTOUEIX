package org.example.canard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeCanardTest {

    @Test
    void testMultiplicateurFort() {
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.Eau, TypeCanard.Feu));
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.Feu, TypeCanard.Glace));
        assertEquals(1.5, TypeCanard.getMultiplicateur(TypeCanard.Glace, TypeCanard.Vent));
    }

    @Test
    void testMultiplicateurFaible() {
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.Feu, TypeCanard.Eau));
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.Glace, TypeCanard.Feu));
        assertEquals(0.5, TypeCanard.getMultiplicateur(TypeCanard.Vent, TypeCanard.Glace));
    }

    @Test
    void testMultiplicateurNeutre() {
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.Vent, TypeCanard.Vent));
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.Eau, TypeCanard.Eau));
        assertEquals(1.0, TypeCanard.getMultiplicateur(TypeCanard.Feu, TypeCanard.Vent));
    }
}

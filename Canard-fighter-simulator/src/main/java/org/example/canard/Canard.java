package org.example.canard;

public class Canard {
    private String nom;
    private TypeCanard type;
    private int pointsDeVie;
    private int pointsAttaque;

    //TODO capacités spéciales

    public Canard(String nom, TypeCanard type, int pointsDeVie, int pointsAttaque) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
    }

    public void attaquer(Canard autreCanard) {
        // TODO inflige des dégâts en fonction du type.
        //— subirDegats(int degats) : réduit les PV du canard.
    }

    public void subirDegats(int degats) {
        this.pointsDeVie -= degats;
    }

    public boolean estKO() {
        return this.pointsDeVie <= 0;
    }

    public String getNom() {
        return nom;
    }

    public TypeCanard getType() {
        return type;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }
}

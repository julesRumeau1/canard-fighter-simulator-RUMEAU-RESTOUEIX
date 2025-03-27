package org.example.canard;

public class Canard {
    private String nom;
    private TypeCanard type;
    private double pointsDeVie;
    private double pointsAttaque;

    //TODO capacités spéciales

    public Canard(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
    }

    public void attaquer(Canard autreCanard) {
        double multiplicateur = TypeCanard.getMultiplicateur(this.type, autreCanard.type);
        double degat = this.pointsAttaque * multiplicateur;
        autreCanard.subirDegats(degat);
    }

    public void subirDegats(double degats) {
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

    public double getPointsDeVie() {
        return pointsDeVie;
    }

    public double getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsDeVie(double pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void activerCapaciteSpeciale(){
    }

}

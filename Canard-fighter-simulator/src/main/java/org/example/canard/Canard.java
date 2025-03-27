package org.example.canard;

public class Canard {
    public Statut statut;
    private String nom;
    private TypeCanard type;
    private double pointsDeVie;
    private double pointsAttaque;
    public boolean capaciteSpecial;


    public Canard(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.capaciteSpecial = true;
        this.statut = Statut.NORMAL;
    }

    public void attaquer(Canard autreCanard) {
        double multiplicateur = TypeCanard.getMultiplicateur(this.type, autreCanard.type);
        double degatSupCapacite = (statut == Statut.AUGMENTATION_DEGATS) ? this.pointsAttaque * 2 : this.pointsAttaque;
        double degat = degatSupCapacite * multiplicateur;
        System.out.println(autreCanard.getNom() + " subit " + degat + " degats ");
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

    public boolean estGele() {
        return this.statut == Statut.GEL;
    }

    public void activerCapaciteSpeciale(Canard cible){
    }

    public boolean getCapaciteSpecial() {
        return capaciteSpecial;
    }
}

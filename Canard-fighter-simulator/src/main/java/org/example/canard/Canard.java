package org.example.canard;

import org.example.capaciteSpeciale.CapaciteRegeneration;
import org.example.capaciteSpeciale.CapaciteSpeciale;

public abstract class Canard {
    public Statut statut;
    private String nom;
    private TypeCanard type;
    private double pointsDeVie;
    private double pointsAttaque;
    public boolean capaciteSpecialDisponible;
    private CapaciteSpeciale capaciteSpeciale;

    public Canard(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque, CapaciteSpeciale capaciteSpeciale) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.capaciteSpecialDisponible = true;
        this.statut = Statut.NORMAL;
        this.capaciteSpeciale = capaciteSpeciale;
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

    public void setStatut(Statut statut) {
        this.statut = statut;
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

    /*
    public void activerCapaciteSpeciale(Canard cible){
        System.out.println(this.nom +'('+this.type+')'+ " utilise sa capacité spéciale" );
    }
    */
    public void activerCapaciteSpeciale(Canard cible) {
        if (capaciteSpeciale != null && capaciteSpecialDisponible) {
            capaciteSpeciale.activer(this, cible);
        } else {
            System.out.println(nom + " ne peut pas utiliser sa capacité spéciale !");
        }
    }

    public boolean getCapaciteSpecialDisponible() {
        return capaciteSpecialDisponible;
    }

    public void setCapaciteSpecialDisponible(boolean capaciteSpecialDisponible) {
        this.capaciteSpecialDisponible = capaciteSpecialDisponible;
    }

    public void setCapaciteSpecial(boolean capaciteSpecial) { this.capaciteSpecialDisponible = capaciteSpecial; }

}

package org.example.canard;

import org.example.capaciteSpeciale.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Canard {
    public Statut statut;
    private String nom;
    private TypeCanard type;
    private double pointsDeVie;
    private double pointsAttaque;
    public boolean capaciteSpecialDisponible;
    private List<CapaciteSpeciale> capacitesSpeciales;

    public Canard(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.capaciteSpecialDisponible = true;
        this.statut = Statut.NORMAL;
        this.capacitesSpeciales = new ArrayList<>();
    }

    public void attaquer(Canard autreCanard) {
        double multiplicateur = TypeCanard.getMultiplicateur(this.type, autreCanard.type);
        double degatSupCapacite = (statut == Statut.AUGMENTATION_DEGATS) ? this.pointsAttaque * 2 : this.pointsAttaque;
        double degat = degatSupCapacite * multiplicateur;
        System.out.println(autreCanard.getNom() + " subit " + degat + " degats ");
        autreCanard.subirDegats(degat);
    }

    public void ajouterCapaciteSpeciale(CapaciteSpeciale capacite) {
        this.capacitesSpeciales.add(capacite);
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
    public void activerCapaciteSpeciale(Canard cible, int index) {
        CapaciteSpeciale capaciteSpeciale= this.getCapaciteSpeciale(index);
        if (capaciteSpeciale != null && capaciteSpecialDisponible) {
            capaciteSpeciale.activer(this, cible);
        } else {
            System.out.println(nom + " ne peut pas utiliser sa capacité spéciale !");
        }
    }

    public boolean getCapaciteSpecialDisponible() {
        return capaciteSpecialDisponible;
    }
    public List<CapaciteSpeciale> getCapacitesSpeciales() {
        return capacitesSpeciales;
    }
    public CapaciteSpeciale getCapaciteSpeciale(int index) {
        return capacitesSpeciales.get(index);
    }

    public void genererBonus() {
        Random random = new Random();
        int bonus = random.nextInt(3) + 1;

        if (bonus == 1) { // ajout pv
            this.pointsDeVie += 10;
            System.out.println(getNom() + " a gagné 10 point de vie !");
        } else if (bonus == 2) { // ajout pa
            this.pointsAttaque += 10;
            System.out.println(getNom() + " a gagné 10 point d'attaque !");
        }
        else if (bonus == 3) { // ajout capacite spéciale
            int indexCapacite = random.nextInt(4) + 1;

            //TODO pas ouf du tout il faudrait faire une capaciteFactory
            if (indexCapacite == 1) {
                this.ajouterCapaciteSpeciale(new CapaciteFlamme());
                System.out.println(getNom() + " a gagné la capacité flamme !");
            } else if (indexCapacite == 2) {
                this.ajouterCapaciteSpeciale(new CapaciteGel());
                System.out.println(getNom() + " a gagné la capacité gel !");
            } else if (indexCapacite == 3) {
                this.ajouterCapaciteSpeciale(new CapaciteRafale());
                System.out.println(getNom() + " a gagné la capacité rafale !");
            } else {
                this.ajouterCapaciteSpeciale(new CapaciteRegeneration());
                System.out.println(getNom() + " a gagné la capacité régénération !");
            }

        }

    }


    public void setCapaciteSpecialDisponible(boolean capaciteSpecialDisponible) {
        this.capaciteSpecialDisponible = capaciteSpecialDisponible;
    }


}

package org.example.canard;

import org.example.capaciteSpeciale.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe abstraite représentant un canard.
 * Chaque canard a un type, des points de vie, des points d'attaque et peut avoir des capacités spéciales.
 */
public abstract class Canard {

    /** Statut actuel du canard (normal, gelé, etc.) */
    public Statut statut;

    /** Nom du canard */
    private String nom;

    /** Type du canard */
    private TypeCanard type;

    /** Points de vie du canard */
    private double pointsDeVie;

    /** Points d'attaque du canard */
    private double pointsAttaque;

    /** Indicateur si la capacité spéciale du canard est disponible */
    public boolean capaciteSpecialDisponible;

    /** Liste des capacités spéciales du canard */
    private List<CapaciteSpeciale> capacitesSpeciales;

    /**
     * Constructeur du canard.
     *
     * @param nom          Le nom du canard.
     * @param type         Le type du canard (par exemple {@link TypeCanard#Eau}).
     * @param pointsDeVie  Les points de vie du canard.
     * @param pointsAttaque Les points d'attaque du canard.
     */
    public Canard(String nom, TypeCanard type, double pointsDeVie, double pointsAttaque) {
        this.nom = nom;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.capaciteSpecialDisponible = true;
        this.statut = Statut.NORMAL;
        this.capacitesSpeciales = new ArrayList<>();
    }

    /**
     * Fait attaquer le canard contre un autre canard.
     * Le dégât infligé dépend du type du canard attaquant et du type du canard cible.
     *
     * @param autreCanard Le canard ciblé par l'attaque.
     */
    public void attaquer(Canard autreCanard) {
        double multiplicateur = TypeCanard.getMultiplicateur(this.type, autreCanard.type);
        double degatSupCapacite = (statut == Statut.AUGMENTATION_DEGATS) ? this.pointsAttaque * 2 : this.pointsAttaque;
        double degat = degatSupCapacite * multiplicateur;
        System.out.println(autreCanard.getNom() + " subit " + degat + " degats ");
        autreCanard.subirDegats(degat);
    }

    /**
     * Ajoute une capacité spéciale au canard.
     *
     * @param capacite La capacité spéciale à ajouter.
     */
    public void ajouterCapaciteSpeciale(CapaciteSpeciale capacite) {
        this.capacitesSpeciales.add(capacite);
    }

    /**
     * Fait subir des dégâts au canard.
     *
     * @param degats Les dégâts à soustraire aux points de vie du canard.
     */
    public void subirDegats(double degats) {
        this.pointsDeVie -= degats;
    }

    /**
     * Vérifie si le canard est KO (points de vie inférieurs ou égaux à zéro).
     *
     * @return true si le canard est KO, false sinon.
     */
    public boolean estKO() {
        return this.pointsDeVie <= 0;
    }

    /**
     * Retourne le nom du canard.
     *
     * @return Le nom du canard.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le statut du canard (gelé, boosté, etc.).
     *
     * @param statut Le nouveau statut du canard.
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     * Retourne le type du canard.
     *
     * @return Le type du canard.
     */
    public TypeCanard getType() {
        return type;
    }

    /**
     * Retourne les points de vie du canard.
     *
     * @return Les points de vie du canard.
     */
    public double getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Retourne les points d'attaque du canard.
     *
     * @return Les points d'attaque du canard.
     */
    public double getPointsAttaque() {
        return pointsAttaque;
    }

    /**
     * Définit les points de vie du canard.
     *
     * @param pointsDeVie Les nouveaux points de vie du canard.
     */
    public void setPointsDeVie(double pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    /**
     * Vérifie si le canard est gelé (ne peut pas attaquer).
     *
     * @return true si le canard est gelé, false sinon.
     */
    public boolean estGele() {
        return this.statut == Statut.GEL;
    }

    /**
     * Active une capacité spéciale pour ce canard.
     * Si la capacité spéciale est disponible, elle est activée sur le canard cible.
     *
     * @param cible Le canard cible de la capacité spéciale.
     * @param index L'index de la capacité spéciale à utiliser.
     */
    public void activerCapaciteSpeciale(Canard cible, int index) {
        CapaciteSpeciale capaciteSpeciale = this.getCapaciteSpeciale(index);
        if (capaciteSpeciale != null && capaciteSpecialDisponible) {
            capaciteSpeciale.activer(this, cible);
        } else {
            System.out.println(nom + " ne peut pas utiliser sa capacité spéciale !");
        }
    }

    /**
     * Retourne si la capacité spéciale est disponible pour ce canard.
     *
     * @return true si la capacité spéciale est disponible, false sinon.
     */
    public boolean getCapaciteSpecialDisponible() {
        return capaciteSpecialDisponible;
    }

    /**
     * Retourne la liste des capacités spéciales du canard.
     *
     * @return La liste des capacités spéciales.
     */
    public List<CapaciteSpeciale> getCapacitesSpeciales() {
        return capacitesSpeciales;
    }

    /**
     * Retourne la capacité spéciale à un index donné.
     *
     * @param index L'index de la capacité spéciale à récupérer.
     * @return La capacité spéciale à l'index spécifié.
     */
    public CapaciteSpeciale getCapaciteSpeciale(int index) {
        return capacitesSpeciales.get(index);
    }

    /**
     * Génère un bonus aléatoire pour le canard (ajout de points de vie, points d'attaque ou une nouvelle capacité spéciale).
     */
    public void genererBonus() {
        Random random = new Random();
        int bonus = random.nextInt(3) + 1;

        if (bonus == 1) { // ajout pv
            this.pointsDeVie += 10;
            System.out.println(getNom() + " a gagné 10 point de vie !");
        } else if (bonus == 2) { // ajout pa
            this.pointsAttaque += 10;
            System.out.println(getNom() + " a gagné 10 point d'attaque !");
        } else if (bonus == 3) { // ajout capacite spéciale
            int indexCapacite = random.nextInt(4) + 1;

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

    /**
     * Définit si la capacité spéciale du canard est disponible ou non.
     *
     * @param capaciteSpecialDisponible true si la capacité spéciale est disponible, false sinon.
     */
    public void setCapaciteSpecialDisponible(boolean capaciteSpecialDisponible) {
        this.capaciteSpecialDisponible = capaciteSpecialDisponible;
    }
}

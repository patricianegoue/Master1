package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

import java.time.LocalDate;
import java.util.Random;

public abstract class Commande {
    private final String name;
    private final int cmdNumber;
    private final LocalDate createdAt;
    private final Vehicule vehicule;

//    private float montantHt;
//    private float montantTva;
//    private float montantTtc;
    private String state = "En cours";

    public Commande(String name, Vehicule vehicule, String state) {
        this.cmdNumber = new Random().nextInt(5);
        this.name = name;
        this.vehicule=vehicule;
        this.state = state;
        this.createdAt = LocalDate.now();
    }
//    public abstract void calculMontantTtc();
//    public abstract void calculTva();
//    public abstract void afficher();
    public void description() {
        System.out.println("Numero de commande : " + cmdNumber + ", nom : " + name + ", contenance : " + vehicule.getName() + ", etat : " + state + ", date de creation : " + createdAt);
    }

    public int getCmdNumber() {return cmdNumber;}
    public String getState() {return state;}
    public abstract LocalDate getDateRembourssement();
}

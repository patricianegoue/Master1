package ABSTRACT_FACTORY;

public abstract class Scooter extends Vehicule {
    public Scooter(String numIm, String name, String color, String marque, String seat, double price) {
        this.numImmatriculation = numIm;
        this.name = name;
        this.price = price;
        this.color = color;
        this.marque = marque;
        this.seat = seat;
    }
    public abstract void afficher();
}

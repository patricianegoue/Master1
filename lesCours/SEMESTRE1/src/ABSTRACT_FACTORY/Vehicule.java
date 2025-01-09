package ABSTRACT_FACTORY;

import DECORATOR_OBSERVER.Observable;
import DECORATOR_OBSERVER.Observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule implements Observable {
    private final List<Observer<Vehicule>> observers = new ArrayList<>();
    protected String name;
    protected String numImmatriculation;
    protected String color;
    protected String marque;
    protected String seat;
    protected double price;
    protected LocalDate createdAt;
    @Override
    public void addObserver(Observer<Vehicule> observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer<Vehicule> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Vehicule> observer : observers) {
            observer.update(this);
        }
    }
    public void setPrice(double prix) {
        this.price = prix;
        notifyObservers();
    }

    public void setNom(String name) {
        this.name = name;
        notifyObservers();
    }

    public void setCouleur(String color) {
        this.color = color;
        notifyObservers();
    }

    public void setMarque(String marque) {
        this.marque = marque;
        notifyObservers();
    }

    public void setSiege(String seat) {
        this.seat = seat;
        notifyObservers();
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public String getColor() {
        return color;
    }
    public String getMarque() {
        return marque;
    }
    public String getNumImmatriculation() {
        return numImmatriculation;
    }

    public String getSeat() {
        return seat;
    }
    public LocalDate getCreatedAt() { return LocalDate.now();};
}

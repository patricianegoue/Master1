package DECORATOR_OBSERVER;

import ABSTRACT_FACTORY.Vehicule;

public abstract class VehiculeDecorator extends Vehicule {
    protected Vehicule decoratedVehicule;

    public VehiculeDecorator(Vehicule decoratedVehicule) {
        this.decoratedVehicule=decoratedVehicule;
    }

    public abstract void visualiserDroite();
    public abstract void visualiserGauche();
}

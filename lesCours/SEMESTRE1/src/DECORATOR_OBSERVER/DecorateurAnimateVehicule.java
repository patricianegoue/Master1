package DECORATOR_OBSERVER;

import ABSTRACT_FACTORY.Vehicule;

public class DecorateurAnimateVehicule extends VehiculeDecorator{
    public DecorateurAnimateVehicule(Vehicule decoratedVehicule) {
        super(decoratedVehicule);
    }

    @Override
    public void visualiserDroite() {
        System.out.println("Animation pour la visualisation a droite");
    }

    @Override
    public void visualiserGauche() {
        System.out.println("Animation pour la visualisation a gauche");
    }
}

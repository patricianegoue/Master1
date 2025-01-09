package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

import java.time.LocalDate;

public class CommandeComptant extends Commande {
    public CommandeComptant(String name, Vehicule vehicule, String state) {
        super(name, vehicule, state);
    }

    @Override
    public LocalDate getDateRembourssement() {
        return null;
    }
}

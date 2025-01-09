package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

import java.time.LocalDate;

public class CommandeCredit extends Commande {
    public CommandeCredit(String name, Vehicule vehicule, String state) {
        super(name, vehicule, state);
    }

    @Override
    public LocalDate getDateRembourssement(){
        return LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().plus(1), LocalDate.now().getDayOfMonth());
    }
}

package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

public class CommandeCreditFactory extends CommandeFactory {
    @Override
    public Commande creerCommande(String name, Vehicule vehicule, String state) {
        return new CommandeCredit(name, vehicule, state);
    }
}

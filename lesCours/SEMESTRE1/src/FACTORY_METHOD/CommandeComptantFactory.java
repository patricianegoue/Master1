package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

public class CommandeComptantFactory extends CommandeFactory {
    @Override
    public Commande creerCommande(String name, Vehicule vehicule, String state) {
        return new CommandeComptant(name, vehicule, state);
    }
}

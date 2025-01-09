package FACTORY_METHOD;

import ABSTRACT_FACTORY.Vehicule;

public abstract class CommandeFactory {
    public abstract Commande creerCommande(String name, Vehicule vehicule, String state);
}

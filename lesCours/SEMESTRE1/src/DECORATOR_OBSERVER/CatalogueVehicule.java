package DECORATOR_OBSERVER;

import ABSTRACT_FACTORY.Vehicule;

import java.util.ArrayList;
import java.util.List;

public class CatalogueVehicule implements Observer<Vehicule> {
    private final List<Vehicule> vehicules;

    public CatalogueVehicule() {
        this.vehicules = new ArrayList<>();
    }

    public void addVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
        vehicule.addObserver(this);
    }

    public void removeVehicule(Vehicule vehicule) {
        vehicules.remove(vehicule);
        vehicule.removeObserver(this);
    }

    @Override
    public void update(Vehicule vehicule) {
        System.out.println("** Vehicule mis a jours **");
        System.out.println("Nom : " + vehicule.getName());
        System.out.println("Prix : " + vehicule.getPrice());
    }

    @Override
    public void getCatalogue() {
        if(vehicules.isEmpty()) {
            System.out.println("Aucun vehicule dans le catalogue \n");
        } else {
            System.out.println("** Vehicules du catalogue **");
            int i =0;
            for(Vehicule vehicule : vehicules) {
                System.out.println(i+1 + ". Numéro d'immatriculation : " + vehicule.getNumImmatriculation() + ".Nom : " + vehicule.getName() + ", Marque : " + vehicule.getMarque() +  ",Couleur : " + vehicule.getColor() + ",Siege : " + vehicule.getSeat() + ",Prix : " + vehicule.getPrice() + "\n");
//            System.out.println("Marque : " + vehicule.getMarque());
//            System.out.println("Couleur : " + vehicule.getColor());
//            System.out.println("Siege : " + vehicule.getSeat());
//            System.out.println("Prix : " + vehicule.getPrice() + "\n");
                i++;
            }
        }
    }

}

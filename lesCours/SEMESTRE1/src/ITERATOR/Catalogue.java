package ITERATOR;

import ABSTRACT_FACTORY.Vehicule;

import java.util.ArrayList;
import java.util.List;

public class Catalogue implements IterableCollection{
    private List<Vehicule> vehicules;

    public Catalogue() {
        this.vehicules = new ArrayList<>();
    }

    public void addVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    @Override
    public Iterator createIterator() {
        return new VehiculeIterator(vehicules);
    }
}

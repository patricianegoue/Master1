package ITERATOR;

import ABSTRACT_FACTORY.Vehicule;

public interface IterableCollection {
    public Iterator createIterator();

    public void addVehicule(Vehicule vehicule);
}

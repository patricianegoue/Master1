package DECORATOR_OBSERVER;

import ABSTRACT_FACTORY.Vehicule;

public interface Observable {
    void addObserver(Observer<Vehicule> observer);

    void removeObserver(Observer<Vehicule> observer);

    void notifyObservers();
}

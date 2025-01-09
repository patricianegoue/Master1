package ITERATOR;

import ABSTRACT_FACTORY.Vehicule;

import java.util.List;

public class VehiculeIterator implements Iterator{
    private List<Vehicule> vehicules;
    private int position;

    public VehiculeIterator(List<Vehicule> books) {
        this.vehicules = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < vehicules.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Vehicule book = vehicules.get(position);
            position++;
            return book;
        }
        return null;
    }
}

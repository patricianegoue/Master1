package ABSTRACT_FACTORY;

public class FabriqueVehiculeElectrique implements IFabriqueVehicule {
    @Override
    public Automobile creerAutomobile(String numIm, String name, String color, String marque, String seat, double price) {
        return new AutoElectrique(numIm, name, color, marque, seat, price);
    }

    @Override
    public Scooter creerScooter(String numIm, String name, String color, String marque, String seat, double price) {
        return new ScooterElectrique(numIm, name, color, marque, seat, price);
    }
}

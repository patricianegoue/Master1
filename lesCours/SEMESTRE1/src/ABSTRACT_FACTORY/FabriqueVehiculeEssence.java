package ABSTRACT_FACTORY;

public class FabriqueVehiculeEssence implements IFabriqueVehicule {
    @Override
    public Automobile creerAutomobile(String numIm, String name, String color, String marque, String seat, double price) {
        return new AutoEssence(numIm, name, color, marque, seat, price);
    }

    @Override
    public Scooter creerScooter(String numIm, String name, String color, String marque, String seat, double price) {
        return new ScooterEssence(numIm, name, color, marque, seat, price);
    }
}

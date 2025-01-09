package ABSTRACT_FACTORY;


public interface IFabriqueVehicule {
    public Automobile creerAutomobile(String numIm, String name, String color, String marque, String seat, double price);
    public Scooter creerScooter(String numIm, String name, String color, String marque, String seat, double price);
}

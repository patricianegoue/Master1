package ABSTRACT_FACTORY;

public class ScooterElectrique extends Scooter {
    public ScooterElectrique(String numIm, String name, String color, String marque, String seat, double price) {
        super(numIm, name, color, marque, seat, price);
    }
    @Override
    public void afficher() {
        System.out.println("*** Scooter electrique ***");
        System.out.println("Nom : " + name);
        System.out.println("Couleur : " + color);
        System.out.println("Marque : " + marque);
        System.out.println("Type de Siege : " + seat);
        System.out.println("Prix : " + price);
    }

}

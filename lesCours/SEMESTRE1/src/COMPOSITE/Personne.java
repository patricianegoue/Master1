package COMPOSITE;

public class Personne implements ClientComposite {
    private String name;
    private String sexe;
    private String numCNI;
    private int age;

    public Personne(String numCNI, String name, int age, String sexe) {
        this.numCNI = numCNI;
        this.name = name;
        this.sexe = sexe;
        this.age =age;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void afficher() {
        System.out.println("Nom de la personne : " + name + " de sexe : " + sexe + " et d'age " + age);
    }

    @Override
    public String getCNI() {
        return numCNI;
    }

    @Override
    public String getNUI() {
        return null;
    }

    @Override
    public void add(ClientComposite client) {

    }

    @Override
    public void remove(ClientComposite client) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String getClient(int index) {
        return null;
    }

}

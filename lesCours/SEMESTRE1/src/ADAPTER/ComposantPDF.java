package ADAPTER;

public class ComposantPDF {
    String contenu;
    public void setContenu(String contenu) {
        System.out.println("Mise a jours du contenu via le composant pdf");
        this.contenu = contenu;
    }

    public void afficher() {
        System.out.println("Contenu du document pdf via le composant =====> \n");
        System.out.println(contenu);
    }
}

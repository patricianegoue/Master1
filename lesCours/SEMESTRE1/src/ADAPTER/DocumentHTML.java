package ADAPTER;

public class DocumentHTML implements DocumentA{
    private String contenu;

    @Override
    public void afficher() {
        System.out.println("Contenu du document html =====> \n ");
        System.out.println(contenu);
    }

    @Override
    public void setContenu(String contenu) {
        System.out.println("Mise a jours du document html");
        this.contenu = contenu;
    }
}

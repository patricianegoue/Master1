package ADAPTER;

public class DocumentPDF implements DocumentA{
    private String contenu;
    private final ComposantPDF composantPDF = new ComposantPDF();

    @Override
    public void afficher() {
        System.out.println("Contenu du document pdf =====> \n");
        composantPDF.afficher();
    }

    @Override
    public void setContenu(String contenu) {
        System.out.println("Mise a jours du document pdf");
        composantPDF.setContenu(contenu);
    }
}

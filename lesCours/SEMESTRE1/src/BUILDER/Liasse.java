package BUILDER;

import java.time.LocalDate;

public class Liasse {
    private static Liasse instanceLiasse = null;
    private String title;
    private Document demandeImmatriculation;
    private Document certificat;
    private Document bonCommande;
    private final LocalDate constructionDate = LocalDate.now();

    public void setDemandeImmatriculation(Document demande) {
        this.demandeImmatriculation = demande;
    }

    public void setBonCommande(Document bonCmd) {
        this.bonCommande = bonCmd;
    }

    public void setCertificat(Document certificat) {
        this.certificat = certificat;
    }
    public String getTitle() {return title;}
    private Liasse(){ super(); }
    private Liasse(String title){ this.title=title; }
    public static Liasse getInstanceLiasse() {
        if(instanceLiasse == null) {
            instanceLiasse = new Liasse();
        }
        return instanceLiasse;
    }
    public static Liasse getInstanceLiasse(String title) {
        if(instanceLiasse == null) {
            instanceLiasse = new Liasse(title);
        }
        return instanceLiasse;
    }

    public void print() {
        System.out.println("\n Contenu de la liasse ( PATRON BUILDER ) === >  \n " + demandeImmatriculation.getDoc() + " \n" + bonCommande.getDoc() + "\n" + certificat.getDoc() + "\n Date de création : " + constructionDate);
    }
}

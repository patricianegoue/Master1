package SINGLETON;

import BUILDER.Document;

import java.time.LocalDate;

public class EmptyLiasse {
    private static EmptyLiasse instanceLiasse = null;
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

    public LocalDate getConstructionDate() {
        return constructionDate;
    }

    public String getTitle() {return title;}

    private EmptyLiasse(){ super(); }
    private EmptyLiasse(String title){ this.title = title; }
    public static EmptyLiasse getInstanceEmptyLiasse() {
        if(instanceLiasse == null) {
            instanceLiasse = new EmptyLiasse();
        }
        return instanceLiasse;
    }

    public static EmptyLiasse getInstanceEmptyLiasse(String title) {
        if(instanceLiasse == null) {
            instanceLiasse = new EmptyLiasse(title);
        }
        return instanceLiasse;
    }

    public void print() {
        System.out.println("\n Contenu de la liasse === >  \n " + demandeImmatriculation.getDoc() + " \n" + bonCommande.getDoc() + "\n" + certificat.getDoc() + "\n Date de création : " + constructionDate);
    }
}

package BUILDER;

public class Directeur {
    MonteurAbstrait monteurLiasse = null;
    public Directeur(MonteurAbstrait monteurLiasse) {this.monteurLiasse = monteurLiasse;}
    public void construire(Liasse liasse, Document demandeIm, Document certif, Document bonCmd){
        if(monteurLiasse.getLiasse() == null) {
            monteurLiasse.creeNouvelleLiasse(liasse);
            monteurLiasse.creerDemandeIm(demandeIm);
            monteurLiasse.creerCertificat(certif);
            monteurLiasse.creerBonCmd(bonCmd);
            monteurLiasse.getLiasse().print();
        } else {
            System.out.println("Une instance de liasse existe déjà. Voulez-vous modifier son contenu ?");
        }
    }
}

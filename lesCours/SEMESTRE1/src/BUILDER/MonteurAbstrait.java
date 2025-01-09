package BUILDER;

public abstract class MonteurAbstrait {
    protected Liasse liasse = null;
    public void creeNouvelleLiasse(Liasse liasse) {
        this.liasse =  liasse;
    }
    public Liasse getLiasse() {
        return liasse;
    }
    public abstract void creerDemandeIm(Document demande);
    public abstract void creerBonCmd(Document bonCmd);
    public abstract void creerCertificat(Document certif);
}

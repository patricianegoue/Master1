package BUILDER;

public class MonteurLiasse extends MonteurAbstrait{
    @Override
    public void creerDemandeIm(Document demande) {
        liasse.setDemandeImmatriculation(demande);
    }

    @Override
    public void creerBonCmd(Document bonCmd) {
        liasse.setBonCommande(bonCmd);
    }

    @Override
    public void creerCertificat(Document certif) {
        liasse.setCertificat(certif);
    }
}

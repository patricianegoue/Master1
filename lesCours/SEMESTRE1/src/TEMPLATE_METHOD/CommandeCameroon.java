package TEMPLATE_METHOD;

public class CommandeCameroon extends CommandeT {
    public CommandeCameroon(double montantHt) {
        super(montantHt);
    }

    @Override
    public void calculMontantTtc() {
        calculTva();
        montantTtc = montantHt + montantTva;
    }

    @Override
    protected void calculTva() {
        montantTva = montantHt * 0.196;
    }

    @Override
    public void afficher() {
        System.out.println("Le montant tout taxe compris de la commande est de " + montantTtc);
    }

    @Override
    public double getMontantTva() {
        return montantTva;
    }
}

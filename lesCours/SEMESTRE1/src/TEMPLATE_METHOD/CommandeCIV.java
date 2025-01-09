package TEMPLATE_METHOD;

public class CommandeCIV extends CommandeT{
    public CommandeCIV(double montantHt) {
        super(montantHt);
    }

    @Override
    public void calculMontantTtc() {
        calculTva();
        montantTtc = montantHt + montantTva;
    }

    @Override
    protected void calculTva() {
        montantTva = montantHt * 0.18;
    }

    @Override
    public double getMontantTva() {
        return montantTva;
    }
    @Override
    public void afficher() {
        System.out.println("Le montant tout taxe compris de la commande est de " + montantTtc);
    }
}

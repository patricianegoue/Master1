package TEMPLATE_METHOD;

public abstract class CommandeT {
    protected double montantHt;
    protected double montantTva;
    protected double montantTtc;

    public CommandeT(double montantHt) {
        this.montantHt = montantHt;
    }

    public abstract void calculMontantTtc();
    protected abstract void calculTva();
    public abstract void afficher();
    public double getMontantTtc() {
        return montantTtc;
    }
    public abstract double getMontantTva();
}

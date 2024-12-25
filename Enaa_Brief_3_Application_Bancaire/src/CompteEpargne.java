public class CompteEpargne extends Compte {
    private String tauxInteret;

    public CompteEpargne(int numero, double salaire, Client proprietaire, String tauxInteret) {
        super(numero, salaire, proprietaire);
        this.tauxInteret = tauxInteret;
    }

    public String getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(String tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "tauxInteret='" + tauxInteret + '\'' +
                '}'+super.toString();
    }
}

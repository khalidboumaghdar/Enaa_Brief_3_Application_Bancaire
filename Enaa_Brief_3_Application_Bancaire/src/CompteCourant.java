public class CompteCourant extends Compte {
    private String fraisBancaires;

    public CompteCourant(int numero, double salaire, Client proprietaire, String fraisBancaires) {
        super(numero, salaire, proprietaire);
        this.fraisBancaires = fraisBancaires;
    }

    public String getFraisBancaires() {
        return fraisBancaires;
    }

    public void setFraisBancaires(String fraisBancaires) {
        this.fraisBancaires = fraisBancaires;
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "fraisBancaires='" + fraisBancaires + '\'' +
                '}'+super.toString();
    }
}

abstract class Compte {
    private  int numero;
    private  double salaire;
    Client proprietaire;

    public Compte(int numero, double salaire, Client proprietaire) {
        this.numero = numero;
        this.salaire = salaire;
        this.proprietaire = proprietaire;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero=" + numero +
                ", salaire=" + salaire +
                ", proprietaire=" + proprietaire +
                '}';
    }
}

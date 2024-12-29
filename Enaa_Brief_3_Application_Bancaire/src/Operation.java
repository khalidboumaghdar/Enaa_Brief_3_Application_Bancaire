import java.util.ArrayList;
import java.util.Scanner;


public class Operation {
    private String type;
    private double montant;
    private String date;
    private CompteCourant compteCourant;
    private CompteEpargne compteEpargne;
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Operation> oprations = new ArrayList<>();




    public Operation(String type, double montant, String date, CompteCourant compteCourant,CompteEpargne compteEpargne) {
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compteCourant = compteCourant;
        this.compteEpargne = compteEpargne;
    }
    public Operation() {


    }




    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getMontant() {
        return montant;
    }


    public void setMontant(double montant) {
        this.montant = montant;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public CompteCourant getCompteCourant() {
        return compteCourant;
    }


    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }


    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }




    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "type='" + type + '\'' +
                ", montant=" + montant +
                ", date='" + date + '\'' +
                ", compteCourant=" + compteCourant +
                ", compteEpargne=" + compteEpargne +
                '}';
    }
}

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

    public  static  void GestionOperation(){
        System.out.println("----------Gestion Operation---------");
        System.out.println("1-Effectuer un dépôt sur un compte");
        System.out.println("2-Effectuer un retrait .");
        System.out.println("3-Effectuer un virement entre deux comptes.");
        System.out.println("4-Afficher lhistorique des opérations pour un compte.");
        int choix;
        choix= sc.nextInt();
        switch(choix){
            case 1:
                EffectuerDepot();
                break;
            case 2:
                EffectuerRetrait();
                break;
            case 3:
                EffectuerVirement();
                break;
            case 4:
                AfficherOpreration();
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
    public static void EffectuerDepot(){
        System.out.println("----------Effectuer Dépôt---------");
        System.out.println("Montant : ");
        double montant = sc.nextDouble();
        sc.nextLine();
        System.out.println("Date : ");
        String date = sc.nextLine();
        System.out.println("--------- Compte ---------- ");
        System.out.println("1-Compte Courant");
        System.out.println("2-Compte Epargne");
        System.out.println("Saisez votre choix :  ");
        int choix = sc.nextInt();
        switch(choix){
            case 1:
                DepotCompteCourant(montant,date);
                break;
            case 2:
                DipotCompteEpargne(montant,date);
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
     public static void EffectuerRetrait() {
        System.out.println("----------Effectuer Retrait---------");
        System.out.println("Montant : ");
        double montant = sc.nextDouble();
        sc.nextLine();
        System.out.println("Date : ");
        String date = sc.nextLine();
        System.out.println("--------- Compte ---------- ");
        System.out.println("1-Compte Courant");
        System.out.println("2-Compte Epargne");
        System.out.println("Saisez votre choix :  ");
        int choix = sc.nextInt();
        switch(choix){
            case 1:
                RetraitCompteCourant(montant,date);
                break;
            case 2:
                RetraitCompteEpargne(montant,date);
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
    public static void DepotCompteCourant(double montant,String date){
        System.out.println("Enter le numero de comptes : ");
        int numeroCompte = sc.nextInt();
        CompteCourant compteCourant = recherCompteCourant(numeroCompte);
        if (compteCourant == null) {
            System.out.println("Compte n'existe pas avec numero : " + numeroCompte);
            return;
        }

        if (montant > compteCourant.getSolde()) {
            System.out.println("Fonds insuffisants pour le retrait.");
            return;
        }
        compteCourant.setSolde(compteCourant.getSolde() + montant);
        Operation operation = new Operation("Dipot", montant, date, compteCourant, null);
        oprations.add(operation);
        System.out.println("Dipot effectué avec succès.");
    }
     public  static  void DipotCompteEpargne(double montant,String date){
        System.out.println("Enter le numero de comptes : ");
        int numeroCompte = sc.nextInt();
        CompteEpargne compteEpargne = recherCompteEpargne(numeroCompte);
        if (compteEpargne == null) {
            System.out.println("Compte n'existe pas avec numero : " + numeroCompte);
            return;
        }

        if (montant > compteEpargne.getSolde()) {
            System.out.println("Fonds insuffisants pour le retrait.");
            return;
        }
        compteEpargne.setSolde(compteEpargne.getSolde() + montant);
        Operation operation = new Operation("Dipot", montant, date, null, compteEpargne);
        oprations.add(operation);
        System.out.println("Dipot effectué avec succès.");
    }
     public static void RetraitCompteCourant(double montant,String date){
        System.out.println("Enter le numero de comptes : ");
        int numeroCompte = sc.nextInt();
        CompteCourant compteCourant = recherCompteCourant(numeroCompte);
        if (compteCourant == null) {
            System.out.println("Compte n'existe pas avec numero : " + numeroCompte);
            return;
        }

        if (montant > compteCourant.getSolde()) {
            System.out.println("Fonds insuffisants pour le retrait.");
            return;
        }
        compteCourant.setSolde(compteCourant.getSolde() - montant);
        Operation operation = new Operation("Retrait", montant, date, compteCourant, null);
        oprations.add(operation);
        System.out.println("Retrait effectué avec succès.");
    }
    public  static  void RetraitCompteEpargne(double montant,String date){
        System.out.println("Enter le numero de comptes : ");
        int numeroCompte = sc.nextInt();
        CompteEpargne compteEpargne = recherCompteEpargne(numeroCompte);
        if (compteEpargne == null) {
            System.out.println("Compte n'existe pas avec numero : " + numeroCompte);
            return;
        }

        if (montant > compteEpargne.getSolde()) {
            System.out.println("Fonds insuffisants pour le retrait.");
            return;
        }
        compteEpargne.setSolde(compteEpargne.getSolde() - montant);
        Operation operation = new Operation("Retrait", montant, date, null, compteEpargne);
        oprations.add(operation);
        System.out.println("Retrait effectué avec succès.");
    }
    public static CompteCourant recherCompteCourant(int numero) {
        for (CompteCourant compteCourant : CompteCourant.compteCourants) {
            if (compteCourant.getNumero()== numero) {
                return compteCourant;
            }
        }
        return null;


    }
      public static CompteEpargne recherCompteEpargne(int numero) {
        for (CompteEpargne compteEpargne : CompteEpargne.compteEpargnes) {
            if (compteEpargne.getNumero()== numero) {
                return compteEpargne;
            }
        }
        return null;


    }
    public static void EffectuerVirement() {
        System.out.println("----------Effectuer un Virement---------");

        System.out.println("Montant : ");
        double montant = sc.nextDouble();
        sc.nextLine();

        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
            return;
        }

        System.out.println("Numéro de compte source : ");
        int numeroCompteSource = sc.nextInt();
        System.out.println("Numéro de compte cible : ");
        int numeroCompteCible = sc.nextInt();

        CompteCourant compteSource = recherCompteCourant(numeroCompteSource);
        CompteCourant compteCible = recherCompteCourant(numeroCompteCible);

        if (compteSource == null) {
            System.out.println("Compte  introuvable.");
            return;
        }
        if (compteCible == null) {
            System.out.println("Compte  introuvable.");
            return;
        }

        if (montant > compteSource.getSolde()) {
            System.out.println("solde > de montant ");
            return;
        }

        compteSource.setSolde(compteSource.getSolde() - montant);
        compteCible.setSolde(compteCible.getSolde() + montant);

        Operation operationDebit = new Operation("Virement salaf", montant, java.time.LocalDate.now().toString(), compteSource, null);
        Operation operationCredit = new Operation("Virement tsalaf", montant, java.time.LocalDate.now().toString(), compteCible, null);

        oprations.add(operationDebit);
        oprations.add(operationCredit);

        System.out.println("Virement effectué avec succès !");
    }
     private static void AfficherOpreration() {
        if (oprations.isEmpty()) {
            System.out.println("Aucun client trouvé.");
        } else {
            for (Operation operation : oprations) {
                System.out.println(operation);
            }
        }
    }
}

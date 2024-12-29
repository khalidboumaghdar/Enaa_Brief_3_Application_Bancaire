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
    public static void GestionCompte() {
        try {
            System.out.println("1-Compte Courant");
            System.out.println("2-Compte Epargne");
            System.out.print("Saisez votre choix :  ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    GestionCompteCourant();
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.nextLine();
        }
    }

    public static void GestionCompteCourant() {
        try {
            System.out.println("\n--- Gestion des Comptes Courants ---");
            System.out.println("1. Créer un compte");
            System.out.println("2. Afficher les informations d'un compte ");
            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    AjouterCompteCourant();
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.nextLine();
        }
    }

    public static void AjouterCompteCourant() {
        try {
            System.out.println("\n--- Ajouter un compte Courant ---");
            System.out.print("Numero : ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Solde : ");
            double solde = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Proprietaire (nom du client) : ");
            String proprietaire = scanner.nextLine();
            Client client = recherClient(proprietaire);

            if (client == null) {
                System.out.println("Erreur : Client n'existe pas !");
                return;
            }

            System.out.print("Frais Bancaires : ");
            String fraisBancaires = scanner.nextLine();
            compteCourants.add(new CompteCourant(numero, solde, client, fraisBancaires));
            System.out.println("Compte Courant ajouté avec succès !");
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer des informations valides !");
            scanner.nextLine();
        }
    }
}

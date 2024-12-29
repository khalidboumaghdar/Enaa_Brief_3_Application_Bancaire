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
    public static void GestionCompteEpargne() {
        try {
            System.out.println("\n--- Gestion des Comptes Epargne ---");
            System.out.println("1. Créer un compte Epargne");
            System.out.println("2. Afficher les informations des comptes Epargne");
            System.out.print("Saisissez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    AjouterCompteEpargne();
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

    public static void AjouterCompteEpargne() {
        try {
            System.out.println("\n--- Ajouter un compte Epargne ---");
            System.out.print("Numero : ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Solde : ");
            double solde = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Propriétaire (nom du client) : ");
            String proprietaire = scanner.nextLine();
            Client client = recherClient(proprietaire);

            if (client == null) {
                System.out.println("Erreur : Le client n'existe pas !");
                return;
            }

            System.out.print("Taux d'intérêt : ");
            String tauxInteret = scanner.nextLine();
            compteEpargnes.add(new CompteEpargne(numero, solde, client, tauxInteret));
            System.out.println("Compte Epargne ajouté avec succès !");
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer des informations valides !");
            scanner.nextLine();
        }
    }

    public static Client recherClient(String proprietaire) {
        for (Client client : Client.clientArrayList) {
            if (client.getNom().equalsIgnoreCase(proprietaire)) {
                return client;
            }
        }
        return null;
    }

    
}

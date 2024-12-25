import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private static ArrayList<Client> clientArrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public Client(int id, String nom, String prenom, String email, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone=" + telephone +
                '}';
    }
    public static void gestionClient() {
        System.out.println("\n--- Gestion des Client ---");
        System.out.println("1. Ajouter un Client");
        System.out.println("2. Modifier un Client");
        System.out.println("3. Supprimer un Client");
        System.out.println("4. Afficher les Client");
        System.out.print("Choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1: AjouterClients(); break;
            case 2: ModifierClient();break;
            case 3: SupprimerClient();break;
            case 4: AfficherClient();break;

            default: System.out.println("Choix invalide !"); break;
        }
    }
    public static boolean RegexTelaphone(String telephone) {
        final String regex = "^((05)|(06)|(07))([0-9]{8})$";
        Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(telephone);
        if(matcher.find()){
            System.out.println("Telephone valide !");
            return true;

        }else{
            System.out.println("Telephone invalide !");
            return false;

        }


    }
    public static boolean RegexEmail(String email){
        final String regex ="^[a-z0-9](\\.?[a-z0-9]){5,}@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            System.out.println("Email valide !");
            return true;
        }else {
            System.out.println("Email invalide !");
            return false;
        }
    }

    public static void AjouterClients() {
        System.out.println("\n--- Ajouter un Clients ---");
        int id  = clientArrayList.size()+1;
        System.out.println("Nom : ");
        String nom = scanner.nextLine();
        System.out.println("Prenom : ");
        String prenom = scanner.nextLine();
        String email;
        do {
            System.out.println("Email : ");
            email = scanner.nextLine();

        }while (!RegexEmail(email));
        System.out.println("Adresse : ");
        String adresse = scanner.nextLine();
        String telephone;
        do {
            System.out.println("Telephone : ");
             telephone = scanner.nextLine();

        }while (!RegexTelaphone(telephone));
        Client client = new Client(id, nom, prenom, email, adresse, telephone);
        clientArrayList.add(client);
        System.out.println("\n Ajout réussi de client!!");

    }
    private static void AfficherClient() {
        if (clientArrayList.isEmpty()) {
            System.out.println("Aucun client trouvé.");
        } else {
            for (Client client : clientArrayList) {
                System.out.println(client);
            }
        }
    }
    public static void ModifierClient() {
        System.out.println("\n--- Modifier un Client ---");
        System.out.println("ID (tu peut modifier un Client):");
        int id  = scanner.nextInt();
        scanner.nextLine();
        for (Client client : clientArrayList) {
            if (client.getId() == id) {
                System.out.println(" Nouveau Nom : " );
                client.setNom(scanner.nextLine());
                System.out.println(" Nouveau Prenom : " );
                client.setPrenom(scanner.nextLine());
                System.out.println(" Nouveau Email : " );
                client.setEmail(scanner.nextLine());
                System.out.println(" Nouveau Adresse : " );
                client.setAdresse(scanner.nextLine());
                System.out.println(" Nouveau Telephone : " );
                client.setTelephone(scanner.nextLine());
                System.out.println("Client Modifier avec succes !!!!");
                return;
            }
        }
        System.out.println(" ID invalide !" );

    }
    public static void SupprimerClient() {
        System.out.println("\n--- Supprimer un Client ---");
        System.out.println("ID (tu peut supprimer un Client):");
        int id  = scanner.nextInt();
        clientArrayList.removeIf(client -> client.getId() == id);
        System.out.println("Client supprime avec succes !!!!");
        
    }

}

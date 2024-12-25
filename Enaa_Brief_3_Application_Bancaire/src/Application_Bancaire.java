import java.util.Scanner;

public class Application_Bancaire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gérer des clients\n");
            System.out.println("4. Quitter");
            System.out.print("Choix: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1 :
                    Client.gestionClient();
                    break;
                case 2 :
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé l'application. Au revoir !!!");
                    break;
                default :
                    System.out.println("Choix invalide, veuillez réessayer !");
            }
        }while (choix!=4);


    }
}
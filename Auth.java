import java.util.Scanner;

public class Auth {

    private static final String defaultUsername = "random";
    private static final String defaultPassword = "strongpassword";
    public static boolean authentication(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Veuillez confirmer votre identité en tapant le mot de passe: ");
        String userPassword = scanner.nextLine();

        if (!username.equals(defaultUsername) || !userPassword.equals(defaultPassword)) {
            System.out.println("Oups, vous n'avez pas accès à ce wallet, désolé.");
            return false;
        }
        return true;
    }

}

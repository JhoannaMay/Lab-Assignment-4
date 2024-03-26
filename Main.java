import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for username
        System.out.print("Enter username:");
        String username = scanner.nextLine();

        // Creating a user
        User user = new User(username, "password");

        try {
            // Attempting login
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter password to login:");
                String passwordAttempt = scanner.nextLine();
                try {
                    user.attemptLogin(passwordAttempt);
                    System.out.flush(); // Explicitly flush output stream
                    break; // Login successful, exit the loop
                } catch (InvalidPasswordException e) {
                    System.out.println("Invalid password :( ");
                    System.out.flush(); // Explicitly flush output stream
                } catch (MaxLoginAttemptsExceededException e) {
                    System.out.println(e.getMessage());
                    System.out.flush(); // Explicitly flush output stream
                    break; // Maximum login attempts exceeded, exit the loop
                }
            }
        } finally {
            scanner.close(); // Close scanner to avoid resource leak
        }
    }
}

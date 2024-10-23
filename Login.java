import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char sym = username.charAt(i);
            password += sym;
        }

        String input = scanner.nextLine();
        int count = 0;
        boolean isBlocked = false;

        while (!input.equals(password)) {
            count++;

            if (count > 3) {
                System.out.printf("User %s blocked!", username);
                isBlocked = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }

        if (!isBlocked) {
            System.out.printf("User %s logged in.", username);
        }
    }
}

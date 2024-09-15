package genericbox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String output = scanner.nextLine();
            System.out.println(new Box<>(output));
        }
    }
}

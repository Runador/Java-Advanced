package generic_swap_method_strings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Box<String> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            box.add(input);
        }
        String[] data = scanner.nextLine().split("\\s");
        box.swap(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        System.out.println(box);
    }
}

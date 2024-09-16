package generic_swap_method_integers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Box<Integer> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            int input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }
        String[] data = scanner.nextLine().split("\\s");
        box.swap(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        System.out.println(box);
    }
}

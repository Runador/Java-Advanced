import java.util.Scanner;

public class SortNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        if (first > second && first > third) {
            System.out.println(first);
        } else if (second > first && second > third) {
            System.out.println(second);
        } else if (third > first && third > second) {
            System.out.println(third);
        }
        if (first < second && first < third) {
            System.out.println(first);
        } else if (second < first && second < third) {
            System.out.println(second);
        } else if (third < first && third < second) {
            System.out.println(third);
        }

    }
}

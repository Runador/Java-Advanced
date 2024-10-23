import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());
        double third = Double.parseDouble(scanner.nextLine());

        double[] numbers = {first, second, third};

        double max = Double.MIN_VALUE;
        double average = 0;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        if (first == max && second == min) {
            average = third;
        } else if (second == max && third == min) {
            average = first;
        } else {
            average = second;
        }

        System.out.printf("%.0f%n", max);
        System.out.printf("%.0f%n", average);
        System.out.printf("%.0f%n", min);
    }
}

package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");

        for (double price : prices) {
            System.out.printf("%.2f%n", addVat.apply(price));
        }
    }
}

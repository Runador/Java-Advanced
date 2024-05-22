package setsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> storeMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {

            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            storeMap.putIfAbsent(shop, new LinkedHashMap<>());
            storeMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : storeMap.entrySet()) {

            String store = entry.getKey();
            System.out.println(store + "->");

            LinkedHashMap<String, Double> productMap = storeMap.get(store);

            for (Map.Entry<String, Double> productsEntry : productMap.entrySet()) {
                String product = productsEntry.getKey();
                double price = productsEntry.getValue();
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            }
        }

    }

}

package shoppingspree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        // Jenya=11;Victor=4
        String[] peoplesData = scanner.nextLine().split(";");
        // Bread=10;Milk=2
        String[] productsData = scanner.nextLine().split(";");

        for (int i = 0; i < peoplesData.length; i++) {
            String[] data = peoplesData[i].split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);
            Person person = new Person(name, money);
            personList.add(person);
        }

        for (int i = 0; i < productsData.length; i++) {
            String[] data = productsData[i].split("=");
            String productName = data[0];
            double cost = Double.parseDouble(data[1]);
            Product product = new Product(productName, cost);
            productList.add(product);
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            String name = data[0];
            String productName = data[1];
            for (Person person : personList) {
                for (Product product : productList) {
                    if (person.getName().equals(name) && product.getName().equals(productName)) {
                        person.buyProduct(product);
                    }
                }
            }

            command = scanner.nextLine();
        }

    }
}

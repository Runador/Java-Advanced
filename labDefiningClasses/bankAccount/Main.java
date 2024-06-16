package labDefiningClasses.bankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            int counter = BankAccount.getId();
            BankAccount bankAccount = new BankAccount();

            switch (command) {
                case "Create":
                    System.out.printf("Account ID%d created%n", counter);
                    counter++;
                    break;
                case "Deposit": {
                    // Deposit {Id} {Amount}
                    int id = BankAccount.getId();
                    double amount = Double.parseDouble(tokens[2]);
                    bankAccount.deposit(20);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    break;
                }
                case "SetInterest":
                    // SetInterest {Interest}
                    double interest = Double.parseDouble(tokens[1]);

                    break;
                case "GetInterest": {
                    // GetInterest {ID} {Years}
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    break;
                }
            }

            input = scanner.nextLine();
        }

    }
}

package definingclasses.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<BankAccount> bankAccounts = new ArrayList<>();
        boolean isDoesNotExist = false;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Create" -> {
                    BankAccount bankAccount = new BankAccount();
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    bankAccounts.add(bankAccount);
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getId() == id) {
                            bankAccount.deposit(amount);
                            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                            isDoesNotExist = false;
                            break;
                        } else {
                            isDoesNotExist = true;
                        }
                    }
                }
                case "SetInterest" -> {
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getId() == id) {
                            System.out.printf("%.2f%n", bankAccount.getInterest(years));
                            isDoesNotExist = false;
                            break;
                        } else {
                            isDoesNotExist = true;
                        }
                    }
                }
            }

            if (isDoesNotExist) {
                System.out.println("Account does not exist");
            }

            input = scanner.nextLine();
        }
    }
}

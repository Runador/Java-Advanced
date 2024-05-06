package DefiningClassesLab.BankAccount;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] bankAccountData = input.split(" ");

            if (bankAccountData[0].equals("Create")) {
                // Create
                BankAccount bankAccount = new BankAccount();
                System.out.printf("Account ID%d created%n", bankAccount.getId());
            } /*else if (bankAccountData[0].equals("Deposit")) {
                // Deposit {Id} {Amount}
                int id = Integer.parseInt(bankAccountData[1]);
                bankAccount.setId(id);
                int amount = Integer.parseInt(bankAccountData[2]);
                bankAccount.deposit(amount);
                System.out.printf("Deposited %d to ID%d%n", amount, id);
            } else if (bankAccountData[0].equals("SetInterest")) {
                // SetInterest {Interest
                double interest = Double.parseDouble(bankAccountData[1]);
                BankAccount.setInterestRate(interest);
            } else if (bankAccountData[0].equals("GetInterest")) {
                // GetInterest {ID} {Years}
                int id = Integer.parseInt(bankAccountData[1]);
                int years = Integer.parseInt(bankAccountData[2]);
                bankAccount.setId(id);
                System.out.println(bankAccount.getInterestRate(years));
            }*/

            input = scanner.nextLine();
        }

    }
}

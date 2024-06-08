package exercisesStacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(n));
    }

    public static long getFibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}

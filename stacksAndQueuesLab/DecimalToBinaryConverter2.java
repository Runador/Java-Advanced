package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(0);
        }

        while (decimalNumber != 0) {
            int reminder = decimalNumber % 2;
            stack.push(reminder);
            decimalNumber /= 2;
        }

        // stack.forEach(System.out::print);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}

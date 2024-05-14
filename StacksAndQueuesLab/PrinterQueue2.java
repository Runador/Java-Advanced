package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();
        String str;

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (!queue.isEmpty()) {
                    str = queue.peekFirst();
                    queue.poll();
                    System.out.println("Canceled " + str);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String element : queue) {
            System.out.println(element);
        }
    }
}

package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")) {

            String currentFile = input;
            printerQueue.offer(currentFile);

            if (input.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println(printerQueue.poll());
                }
            }

            input = scanner.nextLine();
        }

    }
}

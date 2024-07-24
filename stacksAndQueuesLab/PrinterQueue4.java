package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String command = scanner.nextLine();

        while (!command.equals("print")) {

            String fileName = command;
            if (!command.equals("cancel")) {
                printerQueue.offer(fileName);
            }

            if (!printerQueue.isEmpty()) {
                if (command.equals("cancel")) {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                System.out.println("Printer is on standby");
            }

            command = scanner.nextLine();
        }

        printerQueue.forEach(System.out::println);
    }
}

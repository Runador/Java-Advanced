package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String link = null;

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (!historyStack.isEmpty()) {
                    System.out.println(historyStack.pop());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                System.out.println(input);
                if (link != null) {
                    historyStack.push(link);
                } else {
                    link = input;
                }
            }

            input = scanner.nextLine();
        }
    }
}

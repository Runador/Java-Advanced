package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String url = null;

        while (!input.equals("Home")) {

            if (!"back".equals(input)) {
                if (url != null) {
                    historyStack.push(url);
                } else {
                    url = input;
                }
                System.out.println(input);

            } else {
                if (historyStack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    System.out.println(historyStack.pop());
                }
            }

            input = scanner.nextLine();
        }
    }
}

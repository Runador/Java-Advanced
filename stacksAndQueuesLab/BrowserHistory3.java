package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {

            if (browserHistory.size() > 1) {
                browserHistory.pop();
                System.out.println(browserHistory.peek());
            } else {
                System.out.println("no previous URLs");
            }
            if (input.equals("back")) {

            }

            input = scanner.nextLine();
        }

    }
}

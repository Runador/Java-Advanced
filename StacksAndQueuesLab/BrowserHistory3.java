package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                browserHistory.pop();
                System.out.println(browserHistory.peek());
            } else {
                browserHistory.push(input);
                currentURL = browserHistory.peek();
                System.out.println(currentURL);
            }

            input = scanner.nextLine();
        }

    }
}

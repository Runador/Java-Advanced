package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String command = scanner.nextLine();
        String currentTab = "";

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!stack.isEmpty()) {
                    currentTab = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentTab.equals("")) {
                    stack.push(currentTab);
                }
                currentTab = command;
            }

            System.out.println(currentTab);
            command = scanner.nextLine();

        }
    }
}

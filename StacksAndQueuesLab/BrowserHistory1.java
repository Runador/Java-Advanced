package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        String url = "";
        String command = scanner.nextLine();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!browser.isEmpty()) {
                    browser.pop();
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browser.push(url);
                url = command;
                }
            }

            System.out.println(url);
            command = scanner.nextLine();
        }
    }

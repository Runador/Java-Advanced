package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentURL;

        while (!input.equals("Home")) {

            /*  Write a program that takes two types of browser instructions:
                • Normal navigation: a URL is set, given by a string;
                • The string "back" sets the current URL to the last set URL
                After each instruction, the program should print the current URL.
                If the back instruction can't be executed, print "no previous URLs".  */

            currentURL = input;

            if (currentURL.equals("back")) {
                stack.pop();
                if (stack.size() > 1) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                stack.push(currentURL);
            }

            System.out.println(currentURL);

            input = scanner.nextLine();
        }

    }
}

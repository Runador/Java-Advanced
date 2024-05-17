package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String line = scanner.nextLine();
        String currentURL = "";

        while(!line.equals("Home")) {

            if(line.equals("back")) {

                if(!stack.isEmpty()) {

                    currentURL = stack.pop();

                } else {

                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;

                }
            } else {

                if(!currentURL.equals("")) {
                    stack.push(currentURL);
                }

                currentURL = line;
            }

            System.out.println(currentURL);

            line = scanner.nextLine();
        }
    }
}

package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String command = scanner.nextLine();

        String currentURL = null;


        while (!command.equals("Home")) {


            if (command.equals("back")) {
                //System.out.println(command);
            } else {
                currentURL = command;
                System.out.println("no previous URLs");
            }

            if (currentURL != null) {
                System.out.println(currentURL);
            }

            command = scanner.nextLine();
        }



    }
}

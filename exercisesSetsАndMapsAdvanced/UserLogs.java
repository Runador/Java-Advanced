package exercisesSetsАndMapsAdvanced;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> usersMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {

            // IP={IP.Address} message={A&sample&message} user={username}
            String[] tokens = input.split(" ");
            String ipAddress;
            String name = getName(tokens);


            input = scanner.nextLine();
        }

    }

    private static boolean isValidLength(String name) {
        return name.length() >= 3 && name.length() <= 50;
    }

    private static String getIP(String[] input) {

        // IP=192.23.30.40
        // IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329

        String ip = "";

        for (String element : input) {
            for (int i = 0; i < element.length(); i++) {
                int firstIndex;
                if (element.contains("=")) {
                    firstIndex = element.indexOf('=') + 1;
                    char secondIndex = (char) firstIndex;
                    if (Character.isLetter(secondIndex) && Character.isLowerCase(secondIndex)) {
                        ip = element.substring(firstIndex);
                    }
                }
            }
        }
        return ip;
    }

    private static String getName(String[] input) {
        String name = "";
        for (int i = 0; i < input.length; i++) {
            String element = input[i];
            for (int j = 0; j < element.length(); j++) {
                int firstIndex;
                if (element.contains("=")) {
                    firstIndex = element.indexOf('=') + 1;
                    char secondIndex = (char) firstIndex;
                    if (Character.isLetter(secondIndex) && Character.isLowerCase(secondIndex)) {
                        name = element.substring(firstIndex);
                    } else {
                        break;
                    }
                }
            }
        }
        return name;
    }
}

package exercisesSetsАndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {

            Pattern patternIP = Pattern.compile("(?<ip>([A-Z]+[0-9:]+)+|([0-9.]{12,15})+)");
            Matcher matcherIP = patternIP.matcher(input);

            Pattern patternName = Pattern.compile("(?<name>[a-zA-z0-9]*$)");
            Matcher matcherName = patternName.matcher(input);

            String ipAddress = "";
            String name = "";

            if (matcherIP.find()) {
                ipAddress = matcherIP.group("ip");
            }

            if (matcherName.find()) {
                name = matcherName.group("name");
            }

            usersMap.putIfAbsent(name, new LinkedHashMap<>());
            usersMap.get(name).putIfAbsent(ipAddress, 0);

            if (usersMap.containsKey(name)) {
                usersMap.get(name).put(ipAddress, usersMap.get(name).get(ipAddress) + 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entryName : usersMap.entrySet()) {

            String name = entryName.getKey();
            System.out.println(name + ":");

            LinkedHashMap<String, Integer> mapIP = entryName.getValue();
            int count = mapIP.size();

            for (var entryIP : mapIP.entrySet()) {

                String ip = entryIP.getKey();
                int counter = entryIP.getValue();

                if (count == 1) {
                    System.out.printf("%s => %d.", ip, counter);
                } else {
                    System.out.printf("%s => %d, ", ip, counter);
                }

                count--;
            }

            System.out.println();
        }
    }
}

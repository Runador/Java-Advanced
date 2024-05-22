package setsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentCountryCitiesMap
                = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentCountryCitiesMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountryCitiesMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCitiesMap.get(continent).get(country).add(city);

        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>>
                entry : continentCountryCitiesMap.entrySet()) {

            String continent = entry.getKey();
            System.out.println(continent + ":");

            LinkedHashMap<String, List<String>> countriesMap = continentCountryCitiesMap.get(continent);

            for (Map.Entry<String, List<String>> entry1 : countriesMap.entrySet()) {

                String country = entry1.getKey();
                System.out.printf("  %s -> ",country);
                for (int i = 0; i < entry1.getValue().size(); i++) {
                    String city = entry1.getValue().get(i);
                    if (i != entry1.getValue().size() - 1) {
                        System.out.print(city + ", ");
                    } else {
                        System.out.print(city + " ");
                    }
                }
                System.out.println();
            }
        }

    }

}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        // if any plant has more pesticide than the plant at its left, being weaker
        // (more GMO) than the left one, it dies
        // 6 5 8 4 7 10 9
        List<Integer> plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int days = 0;
        for (int i = 0; i < plants.size(); i++) {
            for (int j = 1; j < plants.size(); j++) {
                if (plants.get(i) < plants.get(j)) {
                    plants.remove(plants.get(j));
                    j--;
                } else {
                    i++;
                }
            }
            days++;
        }
        System.out.println(days);
    }
}

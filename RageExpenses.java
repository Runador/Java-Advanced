import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadset = lostGameCount / 2;
        int trashedMouse = lostGameCount / 3;
        int trashedKeyboard = lostGameCount / 6;
        int trashedDisplay = lostGameCount / 12;

        double rageExpenses = (headsetPrice * trashedHeadset) + (mousePrice * trashedMouse) +
                (keyboardPrice * trashedKeyboard) + (displayPrice * trashedDisplay);

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}

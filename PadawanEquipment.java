import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());

        int students = Integer.parseInt(scanner.nextLine());

        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightsabersCount = Math.ceil(students + (students * 0.1));
        double beltsCount = students - (students / 6);
        double sum = (lightsaberPrice * lightsabersCount) + (beltPrice * beltsCount) + (students * robePrice);

        if (amountOfMoney >= sum) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            double diff = Math.abs(sum - amountOfMoney);
            System.out.printf("George Lucas will need %.2flv more.", diff);
        }
    }
}

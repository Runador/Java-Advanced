package carshopextend;

public class Main {
    public static void main(String[] args) {

        Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Car audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);
        System.out.println(printCarInfo(seat));
        System.out.println(seat);
        System.out.println(printCarInfo(audi));
        System.out.println(audi);
    }

    private static String printCarInfo(Car car) {
        return String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower());
    }
}

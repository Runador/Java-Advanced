package needforspeed;

public class Main {
    public static void main(String[] args) {

        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(137, 140);
        raceMotorcycle.drive(5);
        System.out.println(raceMotorcycle.getFuel());

        SportCar sportCar = new SportCar(50, 231);
        sportCar.drive(4);
        System.out.println(sportCar.getFuel());
    }
}

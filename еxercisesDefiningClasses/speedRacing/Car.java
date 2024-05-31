package еxercisesDefiningClasses.speedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void drive(double amountOfKm) {
        double requiredFuel = amountOfKm * fuelCostPerKm;
        if (requiredFuel >= fuelAmount) {
            fuelAmount -= requiredFuel;
            distanceTraveled += amountOfKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

}

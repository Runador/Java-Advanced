package labDefiningClasses.carConstructors;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(), getModel(), getHorsePower());
    }

}


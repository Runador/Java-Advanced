package ferrari;

public class Ferrari implements Car {

    private static final String MODEL = "488-Spider";
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        setModel(MODEL);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return "%s/%s/%s/%s"
                .formatted(MODEL, brakes(), gas(), driverName);
    }
}

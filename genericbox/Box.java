package genericbox;

public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public String toString() {
        return "%s: %s".formatted(value.getClass().getName(), value);
    }
}

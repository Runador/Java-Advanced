package genericbox;

public class Box<T> {

    private T output;

    public Box(T output) {
        this.output = output;
    }

    public String toString() {
        return "java.lang.String: %s".formatted(output);
    }
}

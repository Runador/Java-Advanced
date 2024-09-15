package genericboxofinteger;

public class Box<T> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "%s: %s".formatted(element.getClass().getName(), element);
    }
}

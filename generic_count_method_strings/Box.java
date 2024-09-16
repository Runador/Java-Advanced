package generic_count_method_strings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public String comparingByValue(List<T> list) {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : data) {
            String formattedValue = "%s: %s".formatted(value.getClass().getName(), value);
            stringBuilder.append(formattedValue).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

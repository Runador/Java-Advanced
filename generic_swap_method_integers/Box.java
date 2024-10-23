package generic_swap_method_integers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {

    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(data, firstIndex, secondIndex);
    }

    public void add(T element) {
        data.add(element);
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
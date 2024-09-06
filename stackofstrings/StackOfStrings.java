package stackofstrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private final List<String> data;

    public StackOfStrings() {
        data = new ArrayList<>();
    }

    public void push(String item) {
        if (item != null)
            data.add(item);
    }

    public String pop() {
        String element = data.get(data.size() - 1);
        data.remove(element);
        return element;
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

package stackofstrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings extends ArrayList {

    private List<String> data;

    public StackOfStrings() {
        data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        String output = null;
        if (!data.isEmpty()) {
            output = data.get(data.size() - 1).toString();
            data.remove(data.get(data.size() - 1));
        }
        return output;
    }

    public String peek() {
        String output = null;
        if (!data.isEmpty()) {
            output = data.get(data.size() - 1).toString();
        }
        return output;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

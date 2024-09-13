package Jar;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {

    private final List<T> list;

    public Jar() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public int size() {
        return this.list.size();
    }

    public T remove() {
        return list.remove(list.size() - 1);
    }
}

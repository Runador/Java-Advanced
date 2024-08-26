package customdatastructure;

import java.util.function.Consumer;

public class SmartArray {

    private static final int size = 4;
    private int[] array;
    private int element;

    public SmartArray() {
        array = new int[size];
    }

    public void add(int element) {
        if (array.length == size) {
            int[] newArray = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[this.element] = element;
            this.element++;
    }

    public int get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        return 0;
    }

    public int remove(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                int[] newArray = new int[array.length - 1];
                for (int j = 0; j < newArray.length; j++) {
                    newArray[j] = array[j];
                }
                array = newArray;
            }
        }
        return 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int j : array) {
            consumer.accept(j);
        }
    }

    public boolean contains(int element) {
        for (int j : array) {
            if (j == element) {
                return true;
            }
        }
        return false;
    }

    // Adds element at the specific index, the element at this index gets shifted
    // to the right alongside any following elements, increasing the size

    public void add(int index, int element) {
        if (index >= 0 && index < array.length - 1) {
            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    int[] newArray = new int[array.length - index];
                    for (int j = 0; j < newArray.length; j++) {
                        array[i] = newArray[j];
                    }
                    array[i] = element;
                }
            }
        }
    }

}

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


    public void remove(int index) {
        int[] newArray = new int[array.length - 1];
        int[] firstPartArray = new int[index];
        int[] secondPartArray = new int[newArray.length - 1];
        boolean isEndOfArray = false;
        for (int i = 0; i < array.length; i++) {
            if (index < array.length - 1) {
                if (i == index - 1) {
                    System.arraycopy(array, 0, firstPartArray, 0, firstPartArray.length);
                    if (index != array.length - 1) {
                        for (int j = 0; j < array.length - 2; j++) {
                            secondPartArray[j] = array[j + index + 1];
                        }
                    } else {
                        isEndOfArray = true;
                        break;
                    }
                }
            }
        }
        if (!isEndOfArray) {
            System.arraycopy(firstPartArray, 0, newArray, 0, firstPartArray.length);
            System.arraycopy(secondPartArray, 0, newArray, 0 + index, secondPartArray.length);
            array = newArray;
        } else {
            array = firstPartArray;
        }
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


    public void add(int index, int element) {
        int[] newArray = new int[array.length - index];
        if (index >= 0 && index < array.length - 1) {
            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    for (int j = 0; j < newArray.length; j++) {
                        newArray[j] = array[j + index];
                    }
                    array[i] = element;
                    break;
                }
            }
        } else {
            newArray[newArray.length - 1] = element;
        }
        int[] finalArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            finalArray[i] = array[i];
        }
        int beginIndex = finalArray.length - newArray.length;
        for (int i = 0; i < newArray.length; i++) {
            finalArray[i + beginIndex] = newArray[i];
        }
        array = finalArray;
    }

}

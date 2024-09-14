package jar;

import genericarraycreator.ArrayCreator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();

        for (int i = 0; i < 13; i++) {
            integerJar.add(i);
        }

        Integer[] integers = ArrayCreator.create(10, 13);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

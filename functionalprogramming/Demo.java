package functionalprogramming;

import java.util.function.Consumer;

public class Demo {

    /*void print(String message) {
        System.out.println(message);
    }*/

    Consumer<String> print = System.out::println;

}

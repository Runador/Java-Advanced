package multiple_implementation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Method[] methods = Birthable.class.getDeclaredMethods();
        Method[] methods1 = Identifiable.class.getDeclaredMethods();
        System.out.println(methods.length);
        System.out.println(methods[0].getReturnType().getSimpleName());
        System.out.println(methods1.length);
        System.out.println(methods1[0].getReturnType().getSimpleName());
    }
}

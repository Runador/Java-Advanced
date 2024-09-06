package stackofstrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stackOfStrings = new StackOfStrings();
        System.out.println(stackOfStrings.isEmpty());
        stackOfStrings.push("Sergey");
        System.out.println(stackOfStrings.isEmpty());
        System.out.println(stackOfStrings.peek());
        stackOfStrings.pop();
        System.out.println(stackOfStrings.isEmpty());
    }
}

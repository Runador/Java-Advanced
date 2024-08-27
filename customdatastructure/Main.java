package customdatastructure;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(54);
        smartArray.add(65);
        smartArray.add(79);

        smartArray.forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println(smartArray.get(4));

        smartArray.add(2, 37);
        smartArray.forEach(e -> System.out.print(e + " "));
        System.out.println();
        smartArray.add(1, 666);
        smartArray.forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println();

        smartArray.remove(1);
        smartArray.forEach(e -> System.out.print(e + " "));
        System.out.println();

        smartArray.add(5, 111);
        smartArray.forEach(e -> System.out.print(e + " "));

        System.out.println();
        smartArray.add(1, 34);
        smartArray.forEach(e -> System.out.print(e + " "));

        System.out.println();
        smartArray.add(10);
        smartArray.add(13);
        System.out.println(smartArray.contains(113));
        System.out.println(smartArray.contains(111));

        smartArray.add(10, 12);
    }
}

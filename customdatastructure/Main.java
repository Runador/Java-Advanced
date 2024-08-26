package customdatastructure;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();
        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(54);
        smartArray.add(65);
        smartArray.add(79);

        smartArray.forEach();
        System.out.println();
        System.out.println(smartArray.get(4));
        smartArray.remove(3);
        smartArray.remove(2);
        smartArray.forEach();
        System.out.println();
        System.out.println(smartArray.contains(65));
        System.out.println(smartArray.contains(2));
    }
}

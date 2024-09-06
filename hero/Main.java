package hero;

public class Main {
    public static void main(String[] args) {

        BladeKnight bladeKnight = new BladeKnight("Runador", 37);
        System.out.println(bladeKnight.getName());
        System.out.println(bladeKnight.getLevel());
        System.out.println(bladeKnight.toString());

        Wizard wizard = new Wizard("Olga", 65);
        System.out.println(wizard.getName());
        System.out.println(wizard.getLevel());
        System.out.println(wizard.toString());
    }
}

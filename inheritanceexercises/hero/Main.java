package inheritanceexercises.hero;

public class Main {

    public static void main(String[] args) {

        DarkKnight darkKnight = new DarkKnight("DK", 37);
        System.out.println(darkKnight.getUsername());
        System.out.println(darkKnight.getLevel());
        DarkWizard darkWizard = new DarkWizard("DW", 26);
        System.out.println(darkWizard.getUsername());
        System.out.println(darkWizard.getLevel());
        System.out.println(darkKnight);
        System.out.println(darkWizard);
    }

}

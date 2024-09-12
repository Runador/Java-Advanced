package google;

public class Parent {

    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }
}

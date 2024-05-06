package InheritanceLab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random random;

    public Object getRandomElement() {
        int randomIndex = this.random.nextInt(super.size());
        Object element = super.get(randomIndex);
        super.remove(randomIndex);
        return element;
    }

    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        System.out.println(randomArrayList.getRandomElement());
    }
}

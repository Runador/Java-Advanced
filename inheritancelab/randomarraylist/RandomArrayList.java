package inheritancelab.randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random random = new Random();

    //  returns and removes a random element from the list.
    //    • Public method: getRandomElement(): Object

    public Object getRandomElement() {
        int index = this.random.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}

package inheritancelab.randomarraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    //  returns and removes a random element from the list.
    //    • Public method: getRandomElement(): Object
    private List<Object> arrayList = new ArrayList<>();

    public Object getRandomElement() {
        Random random = new Random();
        return random.nextInt();
    }

}

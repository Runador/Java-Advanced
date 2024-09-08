package randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        int element = size();
        Random random = new Random();
        int index = random.nextInt(element);
        return get(index);
    }
}

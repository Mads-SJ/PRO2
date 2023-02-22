package opg5_bag;

import java.util.HashMap;

public class BagImpl implements Bag {

    HashMap<String, Integer> map = new HashMap<>();

    @Override
    public void add(String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    @Override
    public void remove(String s) {
        if (map.containsKey(s)) {
            if (map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            } else {
                map.remove(s);
            }
        }
    }

    @Override
    public int getCount(String s) {
        return map.getOrDefault(s, 0);
    }
}

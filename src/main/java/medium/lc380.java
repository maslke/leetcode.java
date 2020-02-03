package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int value = list.get(list.size() - 1);
            list.set(index, value);
            map.put(value ,index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int inx = random.nextInt(list.size());
        return list.get(inx);
    }
}
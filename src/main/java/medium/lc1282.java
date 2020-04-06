package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
// 1282. Group the People Given the Group Size They Belong To
class lc1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int v = groupSizes[i];
            if (map.containsKey(v)) {
                List<Integer> list = map.get(v);
                list.add(i);
                if (list.size() == v) {
                    result.add(list);
                    map.remove(v);
                } else {
                    map.put(v, list);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                if (v == 1) {
                    result.add(list);
                } else {
                    map.put(v, list);
                }
            }
        }
        return result;
    }
}
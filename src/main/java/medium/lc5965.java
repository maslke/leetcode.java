package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc5965 {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        long[] ret = new long[arr.length];
        for (List<Integer> list : map.values()) {
            ret[list.get(0)] = getSum(list, list.get(0));
            for (int i = 1; i < list.size(); i++) {
                ret[list.get(i)] = ret[list.get(i - 1)] +
                        i * (list.get(i) - list.get(i - 1)) - (list.size() - i) * (list.get(i) - list.get(i - 1));
            }
        }
        return ret;
    }

    private long getSum(List<Integer> list, int inx) {
        long sum = 0;
        for (Integer v : list) {
            sum += (v - inx);
        }
        return sum;
    }
}

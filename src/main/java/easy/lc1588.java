package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1588 {

    // brute-forec2
    public int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i = i + 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    // brute-force
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 1; i <= arr.length; i++) {
            if (i == 1) {
                List<List<Integer>> list = map.getOrDefault(i, new ArrayList<>());
                for (int j = 0; j < arr.length; j++) {
                    List<Integer> inxs = new ArrayList<>();
                    inxs.add(j);
                    list.add(inxs);
                }
                map.put(i, list);
            } else {
                List<List<Integer>> list = map.get(i - 1);
                List<List<Integer>> newList = map.getOrDefault(i, new ArrayList<>());
                for (List<Integer> items : list) {
                    List<Integer> newItems = new ArrayList<>(items);
                    int value = newItems.get(newItems.size() - 1) + 1;
                    if (value < arr.length) {
                        newItems.add(value);
                        newList.add(newItems);
                    }

                }
                map.put(i, newList);
            }
        }
        for (int i = 1; i <= arr.length; i = i + 2) {
            List<List<Integer>> list = map.get(i);
            for (List<Integer> ls : list) {
                for (Integer value : ls) {
                    sum += arr[value];
                }
            }
        }


        return sum;
    }
}

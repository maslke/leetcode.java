package medium;

// https://leetcode-cn.com/problems/array-of-doubled-pairs/
// 954. 二倍数对数组

import java.util.*;

public class lc954 {

    public boolean canReorderDoubled2(int[] A) {

        Arrays.sort(A);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(i);
            map.put(a, list);
        }

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a > 0) {
                int b = 2 * a;
                if (!map.containsKey(b) || map.get(b).isEmpty()) {
                    return false;
                }
                A[i] = 0;
                List<Integer> list = map.get(b);
                A[list.get(0)] = 0;
                list.remove(0);
            } else if (a < 0) {
                if (a % 2 != 0) {
                    return false;
                }
                int b = a / 2;
                if (!map.containsKey(b) || map.get(b).isEmpty()) {
                    return false;
                }
                A[i] = 0;
                List<Integer> list = map.get(b);
                A[list.get(0)] = 0;
                list.remove(0);
            }
        }

        for (int value : A) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(A);
        for (int a : A) {

            if (!map.containsKey(a)) {
                continue;
            }
            if (a < 0) {
                if (a % 2 != 0 || !map.containsKey(a / 2)) {
                    return false;
                }
                removeKey(a / 2, map);
            } else if (a == 0) {
                if (map.get(a) % 2 != 0) {
                    return false;
                }
                map.remove(a);
            } else {
                if (!map.containsKey(a * 2)) {
                    return false;
                }
                removeKey(a * 2, map);
            }
            removeKey(a, map);
        }

        return map.isEmpty();
    }

    private void removeKey(int a, Map<Integer, Integer> map) {
        if (!map.containsKey(a)) {
            return;
        }
        if (map.get(a) == 1) {
            map.remove(a);
        } else {
            map.put(a, map.get(a) - 1);
        }
    }
}

package easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/
// 1346. Check if N and Its Double Exist

class lc1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (set.contains(v * 2) || (v % 2 == 0 && set.contains(v / 2))) {
                return true;
            }
            set.add(v);
        }
        return false;
    }
}
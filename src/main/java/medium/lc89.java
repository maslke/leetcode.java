package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/gray-code/
// 89. 格雷编码
public class lc89 {
    public List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);


        for (int i = 2; i <= n; i++) {
            int v = (int) Math.pow(2, i - 1);
            List<Integer> temp = new ArrayList<>();
            for (int inx = list.size() - 1; inx >= 0; inx--) {
                temp.add(list.get(inx) + v);
            }
            list.addAll(temp);
        }
        return list;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        backtrace(n, 0, new HashSet<>(), list);
        return list;
    }

    private boolean backtrace(int n, int prev, Set<Integer> set, List<Integer> list) {
        if (set.contains(prev)) {
            return false;
        }
        if (prev >= Math.pow(2, n)) {
            return false;
        }

        list.add(prev);
        set.add(prev);
        if (list.size() == Math.pow(2, n)) {
            int sum = 0;
            for (int i = 0; i < n + 1; i++) {
                sum += (prev >> i) & 1;

            }
            return sum == 1;
        }

        for (int i = 0; i < n + 1; i++) {
            int v = (prev >> i) & 1;
            int prev2 = 0;
            if (v == 1) {
                prev2 = prev & (~(1 << i));
            } else {
                prev2 = prev | (1 << i);
            }
            if (backtrace(n, prev2, set, list)) {
                return true;
            }
        }
        list.remove(list.size() - 1);
        set.remove(prev);
        return false;
    }
}

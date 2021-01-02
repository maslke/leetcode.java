package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
// 842. 将数组拆分成斐波那契序列

public class lc842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        back(S, S.length(), list, 0, 0, 0);
        return list;
    }

    private boolean back(String s, int length, List<Integer> ret, int start, int sum, int prev) {
        if (start == length) {
            return ret.size() >= 3;
        }
        long acc = 0;
        for (int i = start; i < length; i++) {
            if (i > start && s.charAt(start) == '0') {
                break;
            }
            acc = 10 * acc + s.charAt(i) - '0';
            if (acc > Integer.MAX_VALUE) {
                break;
            }
            int acc2 = (int) acc;

            if (ret.size() >= 2) {
                if (acc2 < sum) {
                    continue;
                } else if (acc2 > sum) {
                    break;
                }
            }

            ret.add(acc2);

            if (back(s, length, ret, i + 1, acc2 + prev, acc2)) {
                return true;
            } else {
                ret.remove(ret.size() - 1);
            }
        }

        return false;
    }
}

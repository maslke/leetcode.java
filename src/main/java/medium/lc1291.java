package medium;

// https://leetcode-cn.com/problems/sequential-digits/
// 1291. 顺次数

import java.util.ArrayList;
import java.util.List;

public class lc1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret = new ArrayList<>();
        int n1 = String.valueOf(low).length();
        int n2 = String.valueOf(high).length();

        for (int i = n1; i <= n2; i++) {
            int begin = 0;
            int diff = 0;
            for (int j = 1; j <= i; j++) {
                begin = 10 * begin + j;
                diff = 10 * diff + 1;
            }

            while (begin <= high && begin % 10 != 0) {
                if (begin >= low) {
                    ret.add(begin);
                }
                begin += diff;
            }
        }
        return ret;
    }
}

package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 66. Plus One
 */
public class lc66 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            int[] x = new int[1];
            x[0] = 1;
            return x;
        }
        List<Integer> ret = new ArrayList<Integer>();
        boolean flag = false;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i];
            if(flag) {
                sum += 1;
                flag = false;
            }
            if (sum >= 10) {
                sum -= 10;
                flag = true;
            }
            ret.add(0, sum);
        }
        if (flag) {
            ret.add(0, 1);
        }
        int[] ret1 = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++) {
            ret1[i] = ret.get(i);
        }
        return ret1;
    }
}

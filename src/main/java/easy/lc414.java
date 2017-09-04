package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 414. Third Maximum Number
 */
public class lc414 {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        int[] p = new int[length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int inx = 0;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                p[++inx] = nums[i];
                swim(p, inx);
                map.put(nums[i], 1);
            }
        }
        if (inx < 3) {
            return p[1];
        } else {
            int last = inx;
            for (int i = 1; i < 3; i++) {
                p[1] = p[last];
                p[last] = 1;
                last--;
                sink(p, 1, last);
            }
            return p[1];
        }

    }

    private void swim(int[] p, int k) {
        while(p[k / 2] < p[k] && k > 1) {
            int temp = p[k / 2];
            p[k / 2] = p[k];
            p[k] = temp;
            k = k / 2;
        }
    }

    private void sink(int[] p, int k, int last) {
        while (2 * k <= last) {
            int j = 2 * k;
            if (j < last && p[j] < p[j + 1]) {
                j++;
            }
            if (p[k] < p[j]) {
                int temp = p[k];
                p[k] = p[j];
                p[j] = temp;
            } else {
                break;
            }
            k = j;
        }
    }
}

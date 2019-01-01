import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 645. Set Mismatch
 */
public class lc645 {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int count = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int dbl = 0;
        for (int i = 0; i < count; i++) {
            sum += nums[i];
            if (map.containsKey(nums[i])) {
                dbl = nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        int sum2 = count * ( 1 + count) / 2;
        int[] ret = new int[2];
        ret[0] = dbl;
        ret[1] = dbl + sum2 - sum;
        return ret;
    }
}

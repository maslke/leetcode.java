package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/10
 * Version:0.0.1
 * 507. Perfect Number
 */
public class lc507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 2; i * i <= num; i++) {
            if (map.containsKey(i)) {
                continue;
            }
            if (num % i == 0) {
                map.put(i, 1);
                map.put(num / i, 1);
                sum += i;
                sum += num / i;
                if (sum > num) {
                    return false;
                }
            }
        }
        return sum == num;
    }

    public boolean checkPerfectNumber2(int num) {
        int sum = 1;
        if (num <= 5) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}

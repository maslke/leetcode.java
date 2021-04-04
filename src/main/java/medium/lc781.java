package medium;

// https://leetcode-cn.com/problems/rabbits-in-forest/
// 781. 森林中的兔子

import java.util.HashMap;
import java.util.Map;

public class lc781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>(1024);
        int ret = 0;
        for (int ans : answers) {
            if (map.containsKey(ans)) {
                if (ans > map.get(ans)) {
                    map.put(ans, map.get(ans) + 1);
                }
                else {
                    map.put(ans, 0);
                    ret += 1 + ans;
                }
            }
            else {
                map.put(ans, 0);
                ret += 1 + ans;
            }
        }

        return ret;
    }
}

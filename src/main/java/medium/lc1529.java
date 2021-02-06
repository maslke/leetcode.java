package medium;

// https://leetcode-cn.com/problems/bulb-switcher-iv/
// 1529. 灯泡开关 IV

public class lc1529 {
    public int minFlips(String target) {
        int ret = 0;
        char left = '0';
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c != left) {
                ret++;
                if (left == '0') {
                    left = '1';
                } else {
                    left = '0';
                }
            }
        }
        return ret;
    }
}

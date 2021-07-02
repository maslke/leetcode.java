package medium;

// https://leetcode-cn.com/problems/maximum-ice-cream-bars/
// 1833. 雪糕的最大数量
public class lc1833 {
    private static final int MAX_LENGTH = 100001;

    public int maxIceCream(int[] costs, int coins) {
        int[] values = new int[MAX_LENGTH];
        for (int cost : costs) {
            values[cost]++;
        }
        int i = 0;
        int ret = 0;
        while (i < MAX_LENGTH) {
            if (i > coins) {
                break;
            }
            if (values[i] != 0) {
                coins -= i;
                if (coins >= 0) {
                    ret++;
                }
                values[i]--;
            }
            else {
                i++;
            }
        }
        return ret;
    }
}

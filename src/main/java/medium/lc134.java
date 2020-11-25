package medium;

// https://leetcode-cn.com/problems/gas-station/
// 134. 加油站

public class lc134 {
    // brute force
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int begin = 0;
            int m = i;

            while (true) {
                int left = begin + gas[m] - cost[m];
                if (left < 0) {
                    break;
                }
                begin += gas[m] - cost[m];
                if (m == gas.length - 1) {
                    m = 0;
                } else {
                    m++;
                }

                if (m == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            if (left < min) {
                min = left;
                ret = i;
            }
        }
        return left < 0 ? -1 : (ret + 1) % cost.length;
    }
}

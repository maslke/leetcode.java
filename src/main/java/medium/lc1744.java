package medium;

// https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
// 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
public class lc1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int length = candiesCount.length;
        long[] acc = new long[length];
        acc[0] = candiesCount[0];
        for (int i = 1; i < length; i++) {
            acc[i] = acc[i - 1] + candiesCount[i];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int per = queries[i][2];

            if (acc[type] <= day) {
                res[i] = false;
                continue;
            }

            long v = per * (day + 1L);
            res[i] = v > (type == 0 ? 0 : acc[type - 1]);
        }
        return res;
    }
}

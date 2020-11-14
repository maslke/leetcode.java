package easy;

// https://leetcode-cn.com/problems/water-bottles/
// 1518. 换酒问题

public class lc1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ret = 0;
        int left = 0;
        while (numBottles > 0) {
            ret += numBottles;
            int left2 = (numBottles + left) % numExchange;
            numBottles = (numBottles + left) / numExchange;
            left = left2;
        }

        return ret;
    }
}

package medium;

// https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
// 1423. 可获得的最大点数

public class lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;

        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - 1 - i] + cardPoints[cardPoints.length - 1 - i];
            max = Math.max(max, sum);
        }

        return max;
    }
}

package medium;

// https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
// 1101. 在D天内运送包裹的能力
public class lc1011 {
    public int shipWithinDays(int[] weights, int d) {
        int n = weights.length;
        int min = Integer.MAX_VALUE;
        int left = 1;
        int right = 500 * n;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (valid(weights, middle, d)) {
                min = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }

        return min;
    }

    private boolean valid(int[] weights, int target, int days) {
        int count = 0;
        int n = weights.length;
        int i = 0;
        while (i < n) {
            int j = i;
            int sum = 0;
            if (target < weights[j]) {
                return false;
            }
            while (j < n && (sum + weights[j]) <= target) {
                sum += weights[j];
                j++;
            }

            count++;
            if (j == i) {
                i++;
            }
            else {
                i = j;
            }
        }
        return count <= days;
    }
}

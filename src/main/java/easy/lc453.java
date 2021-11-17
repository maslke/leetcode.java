package easy;

// https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
// 453. 最小操作次数使数组元素相等
public class lc453 {
    public int minMoves(int[] nums) {
        int min = 1000000001;
        for (int n : nums) {
            min = Math.min(min, n);
        }

        int sum = 0;
        for (int n : nums) {
            sum += n - min;
        }
        return sum;
    }
}

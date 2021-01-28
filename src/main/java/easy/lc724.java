package easy;

// https://leetcode-cn.com/problems/find-pivot-index/
// 724. 寻找数组的中心索引

public class lc724 {
    public int pivotIndex(int[] nums) {

        int left = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];

            if (sum == left) {
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}

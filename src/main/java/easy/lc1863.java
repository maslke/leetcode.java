package easy;

// https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals/
// 1863. 找出所有子集的异或总和再求和

public class lc1863 {
    int sum = 0;
    boolean[] visited;

    public int subsetXORSum(int[] nums) {
        int length = nums.length;
        visited = new boolean[length];
        backtrace(nums, 0, 0, 0);
        return sum;
    }

    private void backtrace(int[] nums, int count, int value, int inx) {
        if (count > nums.length) {
            return;
        }
        sum += value;
        for (int i = inx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            value = value ^ nums[i];
            visited[i] = true;
            backtrace(nums, count + 1, value, i);
            value = value ^ nums[i];
            visited[i] = false;
        }
    }
}

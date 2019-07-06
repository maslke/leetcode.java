package medium;

// https://leetcode.com/problems/subarray-sum-equals-k/

// 560. Subarray Sum Equals K

class lc560 {

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }

        return count;

    }
}
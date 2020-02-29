package medium;

// https://leetcode.com/problems/find-the-duplicate-number/
// 287. Find the Duplicate Number

class lc287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }   
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
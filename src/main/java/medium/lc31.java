package medium;

// https://leetcode-cn.com/problems/next-permutation/
// 31. 下一个全排列

class lc31 {

    public void nextPermutation2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = nums.length - 1;
        while (index > 0) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
            index--;
        }
        if (index == 0) {
            reverse(nums, index);
            return;
        }
        int swapIndex = nums.length - 1;
        while (swapIndex >= 0) {
            if (nums[index - 1] >= nums[swapIndex]) {
                swapIndex--;
            } else {
                break;
            }
        }
        swap(nums, swapIndex, index - 1);
        reverse(nums, index);
    }

    private void reverse(int[] nums, int index) {
        int left = index;
        int right= nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
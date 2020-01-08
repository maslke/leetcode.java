package medium;

class lc31 {
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
        if (index < nums.length - 1) {
            for (int i = index, j = nums.length - 1; i < j; i++, j--) {
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
package easy;

class lc747 {
    public int dominantIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (index == i) continue;
            if (nums[i] * 2 > max) return -1;
        }
        return index;
    }
}
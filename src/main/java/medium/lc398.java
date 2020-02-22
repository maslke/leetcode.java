package medium;

import java.util.Random;


class lc398 {

    private int[] values;
    private Random random;

    public lc398(int[] nums) {
        this.values = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int i = -1;
        int j = -1;
        for (int m = 0; m < values.length; m++) {
            if (values[m] == target) {
                if (i == -1) {
                    i = m;
                } else {
                    j = m;
                }
            } else {
                if (i != -1) {
                    break;
                }
            }
        }

        if (j == -1) return i;
        int count = j - i + 1;
        return i + random.nextInt(count);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
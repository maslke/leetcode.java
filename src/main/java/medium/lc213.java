package medium;

public class lc213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] choices = new int[2 * n - 2];
        choices[0] = nums[0];
        choices[1] = Math.max(nums[0], nums[1]);
        int inx = 2;
        for (int i = 2; i < nums.length - 1; i++) {
            choices[inx++] = Math.max(choices[i - 1], choices[i - 2] + nums[i]);
        }


        choices[inx++] = nums[1];
        choices[inx++] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            choices[inx] = Math.max(choices[inx - 1], choices[inx - 2] + nums[i]);
            inx++;
        }
        int max = 0;
        for (int i = 0; i < choices.length; i++) {
            max = Math.max(choices[i], max);
        }
        return max;
    }
}

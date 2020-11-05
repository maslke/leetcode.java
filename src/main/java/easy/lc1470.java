package easy;

public class lc1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        int inx = 0;
        for (int i = 0; i < nums.length; i++) {
            result[inx++] = nums[i];
            result[inx++] = nums[i + n];
        }
        return result;
    }
}

package easy;

// https://leetcode-cn.com/problems/remove-element/
// 27. 移除元素

public class lc27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int count = 0;
        while (i < length) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
            i++;

        }
        return count;
    }
}

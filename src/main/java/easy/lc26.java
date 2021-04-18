package easy;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// 26. 删除有序数组中的重复项

public class lc26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        int inx = 0;
        while (i < length) {
            int j = i;
            while (j < length && nums[j] == nums[i]) {
                j++;
            }

            nums[inx++] = nums[i];
            i = j;
        }


        return inx;
    }
}

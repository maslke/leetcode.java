package medium;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
// 80. 删除有序数组中的重复项 II
class lc80 {

    public int removeDuplicates3(int[] nums) {
        int length = nums.length;
        int slow = 2;
        int fast = 2;
        if (length <= 2) {
            return length;
        }
        while (fast < length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
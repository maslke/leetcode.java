package medium;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
// 80. 删除有序数组中的重复项 II
class lc80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int m = i;
            while (m < j) {
                if (nums[m] == nums[i]) {
                    m++;
                }
                else {
                    break;
                }
            }
            int count = m - i;
            if (count <= 2) {
                i = i + count;
            }
            else {
                for (int inx = m; inx < j; inx++) {
                    nums[i + inx - m + 2] = nums[inx];
                }
                j = j - (m - i) + 2;
                i = i + 2;
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        int i = 0;
        int ret = 0;
        while (i < length) {
            int j = i;
            int count = 0;
            while (j < length && nums[j] == nums[i]) {
                j++;
                count++;
            }
            if (count > 2) {
                int n = j - count + 2;
                for (int k = j; k < length; k++) {
                    nums[n++] = nums[k];
                }
                ret += 2;
                i = j - count + 2;
                length = length - (count - 2);
            }
            else {
                ret += count;
                i = j;
            }

        }
        return ret;
    }
}
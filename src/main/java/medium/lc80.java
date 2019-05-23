package medium;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//80. Remove Duplicates from Sorted Array II
class lc80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = nums.length;
        while ( i < j) {
            int m = i;
            while (m < j) {
                if (nums[m] == nums[i]) {
                    m++;
                } else {
                    break;
                }
            }
            int count = m - i;
            if (count <= 2) {
                i = i + count;
            } else {
                for (int inx = m; inx < j; inx++) {
                    nums[i + inx - m + 2] = nums[inx];
                }
                j = j - (m - i) + 2;
                i = i + 2;
            }
        }
        return j;
    }
}
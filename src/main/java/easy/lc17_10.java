package easy;

// https://leetcode-cn.com/problems/find-majority-element-lcci/
// 面试题17.10 主要元素
public class lc17_10 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int value = -1;
        for (int n : nums) {
            if (count == 0) {
                value = n;
                count++;
            }
            else {
                if (value == n) {
                    count++;
                }
                else {
                    count--;
                }
            }
        }

        if (count > 0) {
            int fre = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == value) {
                    fre++;
                }
            }
            return fre > nums.length / 2 ? value : -1;
        }

        return -1;
    }
}

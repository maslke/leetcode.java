package easy;


// https://leetcode.com/problems/single-number/
// 136. Single Number

public class lc136 {

    public int singleNumber(int[] nums) {
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            v = nums[i] ^ v;
        }
        return v;
    }
}

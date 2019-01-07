//https://leetcode.com/problems/jump-game/
//55. Jump Game
class Solution {
    public boolean canJump(int[] nums) {
       if (nums.length <= 1) return true;
        int i = 0;
        int j = nums.length;
        int reach = 0;
        while (i < j - 1) {
            reach = Math.max(reach, i + nums[i]);
            if (reach <= i) return false;
            if (reach >= j - 1) return true;
            i++;
        }
        return false;
    }
}
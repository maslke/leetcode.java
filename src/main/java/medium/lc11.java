package medium;

// https://leetcode-cn.com/problems/container-with-most-water/
// 11. 盛最多水的容器

public class lc11 {
    public int maxArea(int[] height) {
        int ret = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int sum = Math.min(height[i], height[j]) * (j - i);
            if (sum > ret) {
                ret = sum;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }
}

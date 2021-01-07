package hard;

// https://leetcode-cn.com/problems/volume-of-histogram-lcci/
// 面试题 17.21. 直方图的水量

public class lc17_21 {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int[] left = new int[len];
        left[0] = 0;
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int[] right = new int[len];
        right[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            int v = Math.min(left[i], right[i]) - height[i];
            if (v > 0) {
                count += v;
            }
        }
        return count;
    }
}

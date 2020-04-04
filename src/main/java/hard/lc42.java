package hard;

// https://leetcode-cn.com/problems/trapping-rain-water/
// 42. 接雨水

class lc42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ret = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            left[i] = Integer.max(height[i - 1], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i +1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min = Integer.min(left[i], right[i]);
            ret += Integer.max(0, min - height[i]);
        }

        return ret;

    }
}
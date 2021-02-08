package medium;

// https://leetcode-cn.com/problems/longest-turbulent-subarray/
// 978. 最长湍流子数组

public class lc978 {
    public int maxTurbulenceSize(int[] arr) {
        int ret = 1;
        int left = 0;
        int right = 1;
        int len = arr.length;
        while (right < len) {
            if (right - left > 1) {
                if ((arr[right] - arr[right - 1] <= 0 && arr[right - 1] - arr[right - 2] <= 0)
                        || (arr[right] - arr[right - 1] >= 0 && arr[right - 1] - arr[right - 2] >= 0)) {
                    ret = Math.max(ret, right - left);
                    left = right - 1;
                    continue;
                }
            }
            else {
                if (arr[right] == arr[right - 1]) {
                    left = right;
                    right = right + 1;
                    continue;
                }
            }
            right++;
        }
        return Math.max(ret, right - left);
    }
}

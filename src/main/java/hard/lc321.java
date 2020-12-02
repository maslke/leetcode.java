package hard;

import java.util.Stack;

// https://leetcode-cn.com/problems/create-maximum-number/
// 321. 拼接最大数

public class lc321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] ret = new int[k];
        for (int i = 0; i <= k; i++) {
            int x = i;
            if (x > length1) {
                continue;
            }
            int y = k - i;
            if (y < 0 || y > length2) {
                continue;
            }
            // take x + y = k
            int[] data1 = take(nums1, x);
            int[] data2 = take(nums2, y);
            int[] result = merge(data1, data2);
            if (compare(result, 0, ret, 0) > 0) {
                ret = result;
            }
        }

        return ret;
    }


    // 两个最大子序列进行合并
    private int[] merge(int[] data1, int[] data2) {
        int[] ret = new int[data1.length + data2.length];
        int i = 0;
        int j = 0;
        int inx = 0;
        while (i < data1.length && j < data2.length) {
            if (data1[i] > data2[j]) {
                ret[inx++] = data1[i++];
            } else if (data1[i] < data2[j]) {
                ret[inx++] = data2[j++];
            } else {
                if (compare(data1, i + 1, data2, j + 1) > 0) {
                    ret[inx++] = data1[i++];
                } else {
                    ret[inx++] = data2[j++];
                }
            }
        }
        while (i < data1.length) {
            ret[inx++] = data1[i++];
        }
        while (j < data2.length) {
            ret[inx++] = data2[j++];
        }
        return ret;
    }

    private int compare(int[] data1, int i, int[] data2, int j) {
        int m = i;
        int n = j;
        while (m < data1.length && n < data2.length) {
            int d = data1[m] - data2[n];
            if (d != 0) {
                return d;
            }
            m++;
            n++;
        }

        if (m < data1.length && n == data2.length) {
            return 1;
        }
        if (m == data1.length && n < data2.length) {
            return -1;
        }
        return 0;
    }

    private int[] take(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int remaining = nums.length - k;
        for (int num : nums) {
            while (remaining > 0 & !stack.isEmpty() && stack.peek() < num) {
                remaining--;
                stack.pop();
            }
            stack.push(num);
        }
        for (int i = 0; i < remaining; i++) {
            stack.pop();
        }
        int[] ret = new int[k];
        int inx = ret.length - 1;
        while (!stack.isEmpty()) {
            ret[inx--] = stack.pop();
        }
        return ret;

    }
}

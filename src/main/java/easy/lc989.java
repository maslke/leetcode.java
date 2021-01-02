package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/add-to-array-form-of-integer/
// 989. 数组形式的整数加法

class lc989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        char[] b = String.valueOf(K).toCharArray();
        boolean added = false;
        int i = A.length - 1;
        int j = b.length - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0 && j >= 0) {
                sum = A[i] + (b[j] - '0');
            } else if (i >= 0) {
                sum = A[i];
            } else {
                sum = (b[j] - '0');
            }
            if (added) {
                sum += 1;
                added = false;
            }
            if (sum >= 10) {
                sum -= 10;
                added = true;
            }
            list.offerFirst(sum);
            i--;
            j--;
        }
        if (added) {
            list.offerFirst(1);
        }
        return list;
    }
}
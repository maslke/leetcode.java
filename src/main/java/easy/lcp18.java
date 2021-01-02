package easy;

import java.util.Arrays;

// https://leetcode-cn.com/problems/2vYnGI/
// LCP18. 早餐组合

public class lcp18 {

    // solution 2
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        long ret = 0;
        Arrays.sort(drinks);
        Arrays.sort(staple);

        int i = 0;
        int j = drinks.length - 1;
        while (i < staple.length && j >= 0) {
            int val = staple[i] + drinks[j];
            if (val > x) {
                j--;
            } else {
                ret += j + 1;
                i++;
            }
        }
        return (int) (ret % (1e9 + 7));
    }


    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        long ret = 0;
        Arrays.sort(drinks);
        for (int i = 0; i < staple.length; i++) {
            int left = x - staple[i];
            ret += findLastLessIndex(drinks, 0, drinks.length - 1, left + 1) + 1;
        }

        return (int) (ret % (1e9 + 7));
    }

    private int findLastLessIndex(int[] num, int left, int right, int value) {
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int val = num[middle];
            if (val >= value) {
                right = middle - 1;
            } else {
                if (middle == right || num[middle + 1] >= value) {
                    return middle;
                }
                left = middle + 1;
            }
        }
        return right;
    }
}

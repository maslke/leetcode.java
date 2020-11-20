package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/interval-list-intersections/
// 986. 区间列表的交集

public class lc986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[0] > b[1]) {
                j++;
            }
            else if (b[0] > a[1]) {
                i++;
            }
            else {

                list.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] == b[1]) {
                    i++;
                    j++;
                }
                else if (a[1] > b[1]) {
                    b[0] = a[1] + 1;
                    j++;
                }
                else {
                    a[0] = b[1] + 1;
                    i++;
                }
            }

        }
        return list.toArray(new int[0][2]);
    }
}

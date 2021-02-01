package easy;

// https://leetcode-cn.com/problems/fair-candy-swap/
// 888. 公平的糖果棒交换

public class lc888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;

        int[] c1 = new int[100001];
        int[] c2 = new int[100001];

        for (int aA : A) {
            diff += aA;
            c1[aA]++;
        }
        for (int aB : B) {
            diff -= aB;
            c2[aB]++;
        }
        int[] res = new int[2];
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == 0) {
                continue;
            }
            int v2 = (int)(i - 0.5 * diff);
            if (v2 > 0 && c2[v2] > 0) {
                res = new int[]{i, v2};
                break;
            }
        }
        return res;
    }
}

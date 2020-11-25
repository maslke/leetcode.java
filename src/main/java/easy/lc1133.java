package easy;

// https://leetcode-cn.com/problems/largest-unique-number/
// 1133. 最大唯一数

// 1 <= A.length <= 2000
// 0 <= A[i] <= 1000

class lc1133 {
    public int largestUniqueNumber(int[] A) {
        int[] a = new int[1001];
        for (int i = 0; i < A.length; i++) {
            a[A[i]]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (a[i] == 1) return i;
        }
        return -1;
    }
}
package medium;

// https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
// 1310. 子数组异或查询

public class lc1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ret = new int[queries.length];
        int[] v = new int[arr.length];
        v[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            v[i] = v[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            ret[i] = v[queries[i][1]] ^ v[queries[i][0]] ^ arr[queries[i][0]];
        }

        return ret;
    }
}

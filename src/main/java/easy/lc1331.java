package easy;

// https://leetcode.com/problems/rank-transform-of-an-array/
// 1331. Rank Transform of an Array

class lc1331 {
    public int[] arrayRankTransform(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int v : arr) {
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }
        
        int[] ret = new int[max - min + 1];
        for (int v : arr) {
            ret[v - min]++;
        }
        
        int k = 1;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != 0) {
                ret[i] = k++;
            }
        }
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = ret[arr[i] - min];
        }
        return result;
    }
}
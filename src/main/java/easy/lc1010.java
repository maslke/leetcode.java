package easy;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// 1010. Pairs of Songs With Total Durations Divisible by 60
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int length = time.length;
        int[] ret = new int[60];
        for (int i = 0; i < length; i++) {
            int v = time[i] % 60;
            ret[v]++;
        }
        int count = 0;
        for (int i = 0; i < ret.length; i++) {
            for (int j = i + 1; j < ret.length; j++) {
                if ((i + j) % 60 == 0) {
                    count += ret[i] * ret[j];
                }
            }
            if ((i + i) % 60 == 0) {
                count += ret[i] * (ret[i] - 1) / 2;
            }
        }
        return count;
        
        
    }
}
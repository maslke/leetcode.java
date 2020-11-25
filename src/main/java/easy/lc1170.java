package easy;

import java.util.Arrays;

// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
// 1170. Compare Strings by Frequency of the Smallest Character


class lc1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ret = new int[queries.length];
        int[] fs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fs[i] = fre(words[i]);
        }
        Arrays.sort(fs);


        for (int i = 0; i <queries.length; i++) {
            int f = fre(queries[i]);
            int inx = 0;
            for (int j = 0;j < fs.length; j++) {
                if (f < fs[j]) {
                    break;
                } else {
                    inx++;
                }
            }
            ret[i] = fs.length - inx;
        }
        return ret;
    }

    private int fre(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        int count = 0;
        int c = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
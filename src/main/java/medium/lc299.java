package medium;

import java.util.Arrays;

// https://leetcode.com/problems/bulls-and-cows/
// 299. Bulls and Cows

class lc299 {
    public String getHint(String secret, String guess) {
        char[] cs = secret.toCharArray();
        char[] cg = guess.toCharArray();

        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == cg[i]) {
                count++;
            }
        }

        Arrays.sort(cs);
        Arrays.sort(cg);

        int i = 0;
        int j = 0;
        int count2 = 0;
        while (i < cs.length && j < cg.length) {
            if (cs[i] == cg[j]) {
                i++;
                j++;
                count2++;
            } else if (cs[i] < cg[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count + "A" + (count2 - count) + "B";
    }
}
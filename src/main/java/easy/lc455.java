package easy;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/
// 455. Assign Cookies

class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < s.length && i < g.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        } 
        return count;
    }
}
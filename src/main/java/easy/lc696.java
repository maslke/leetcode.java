package easy;

//https://leetcode.com/problems/count-binary-substrings/
//696. Count Binary Substrings

import java.util.List;
import java.util.ArrayList;

class lc696 {
    public int countBinarySubstrings(String s) {
        int i = 0;
        int j = s.length();
        int count = 0;
        while (i < j) {
            char c = s.charAt(i);
            int m = i + 1;
            while (m < j) {
                if (s.charAt(m) == c) {
                    m++;
                } else {
                    break;
                }
            }
            if (m + m - i <= j) {
                String s1 = s.substring(i, m);
                String s2 = s.substring(m, m + m - i);
                int k = 0;
                while (k < s1.length()) {
                    if (s1.charAt(k) == s2.charAt(k)) {
                        break;
                    }
                    k++;
                }
                if (k == s1.length()) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

    // a much better solution
    public int countBinarySubstrings2(String s) {
        List<Integer> values = new ArrayList<>();
        int i = 0;
        int j = s.length();
        while (i < j) {
            char c = s.charAt(i);
            int m = i + 1;
            while (m < j) {
                if (s.charAt(m) == c) {
                    m++;
                } else {
                    break;
                }
            }
            values.add(m - i);
            i = m;
        }
        int ret = 0;
        int size = values.size();
        for (i = 0; i < size - 1; i++) {
            ret += Math.min(values.get(i), values.get(i + 1));
        }
        return ret;
    }
}

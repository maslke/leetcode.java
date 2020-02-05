package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.StringBuilder;

// https://leetcode.com/contest/weekly-contest-172/problems/print-words-vertically/
// 1324. Print Words Vertically
class lc1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        List<String> ret = new ArrayList<>();
        if (s.length() == 0) return ret;
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= length) {
                length = words[i].length();
            }
        }
        
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                } else {
                   sb.append(' ');
                }
            }
            String word = sb.toString();
            int m = word.length();
            while (m > 0 && word.charAt(m - 1) == ' ') {
                m--;
            }
            
            ret.add(word.substring(0, m));
        }
        return ret;
        }
}
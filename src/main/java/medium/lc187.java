package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/repeated-dna-sequences/
// 187. 重复的DNA序列

public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                chars[i] = '0';
            }
            else if (chars[i] == 'C') {
                chars[i] = '1';
            }
            else if (chars[i] == 'G') {
                chars[i] = '2';
            }
            else {
                chars[i] = '3';
            }
        }

        int v = 0;
        for (int i = 0; i < 10; i++) {
            v += (chars[i] - '0') * (int) (Math.pow(4, 9 - i));
        }

        Set<Integer> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        List<String> ret = new ArrayList<>();
        set.add(v);

        for (int i = 10; i < s.length(); i++) {
            v = v * 4 - (chars[i - 10] - '0') * (int) Math.pow(4, 10) + (chars[i] - '0');
            if (set.contains(v)) {
                String temp = s.substring(i - 9, i + 1);
                if (!set2.contains(temp)) {
                    ret.add(temp);
                    set2.add(temp);
                }
            }
            else {
                set.add(v);
            }

        }
        return ret;
    }
}

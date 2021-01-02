package medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique/
// 1647. 字符频次唯一的最小删除次数

public class lc1647 {
    public int minDeletions(String s) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int time : times) {
            if (time == 0) {
                continue;
            }
            list.add(time);
        }
        int inx = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        while (inx < list.size()) {
            int v = list.get(inx);
            if (set.contains(v)) {
                int m = v;
                while (set.contains(m)) {
                    m--;
                    count++;
                }
                if (m != 0) {
                    set.add(m);
                }
            } else {
                set.add(v);
            }
            inx++;
        }
        return count;
    }
}

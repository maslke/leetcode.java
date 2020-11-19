package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/partition-labels/
// 763. Partition Labels

class lc763 {
    public List<List<Integer>> combine(int n, int k) {
        Queue<List<Integer>> ret = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> set = new ArrayList<>();
            set.add(i);
            ret.offer(set);
        }

        for (int i = 2; i <= k; i++) {
            int size = ret.size();
            for (int inx = 0; inx < size; inx++) {
                List<Integer> list = ret.poll();
                for (int j = list.get(list.size() - 1) + 1; j <= n; j++) {
                    List<Integer> list2 = new ArrayList<>(list);
                    if (!list2.contains(j)) {
                        list2.add(j);
                    }
                }
            }
        }

        return new ArrayList<>(ret);

    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> ret = new ArrayList<>();

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] = i;
        }

        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, chars[c - 'a']);
            if (i == end) {

                ret.add(end - begin + 1);
                begin = end + 1;
            }
        }

        return ret;
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();

        int[] chars = new int[26];
        for (int i = 0; i < S.length(); i++) {
            chars[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (chars[c - 'a'] == i) {
                result.add(1);
                i++;
            }
            else {
                int max = chars[c - 'a'];
                int m = i;
                while (m < max) {
                    char c1 = S.charAt(m);
                    max = Math.max(chars[c1 - 'a'], max);
                    m++;
                }
                result.add(m - i + 1);
                i = m + 1;
            }
        }
        return result;
    }
}
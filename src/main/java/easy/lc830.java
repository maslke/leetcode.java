package easy;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 * lc.830
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        int len = S.length();
        while (i < len) {
            char c = S.charAt(i);
            int m = i;
            while (m < len) {
                if (S.charAt(m) != c) {
                    break;
                }
                m++;
            }
            int j = m - i;
            if (j >= 3) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                indexes.add(m - 1);
                result.add(indexes);
            }
            i = m;
        }
        return result;
    }
}
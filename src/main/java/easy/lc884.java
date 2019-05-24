package easy;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * 884. Uncommon Words from Two Sentences
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

 * Return a list of all uncommon words. 

 * You may return the list in any order.
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] c1 = A.split(" ");
        String[] c2 = B.split(" ");
        for (int i = 0; i < c1.length; i++) {
            if (!map.containsKey(c1[i])) {
                map.put(c1[i], 1);
            } else {
                map.put(c1[i], map.get(c1[i]) + 1);
            }
        }
        for (int i = 0; i < c2.length; i++) {
            if (!map.containsKey(c2[i])) {
                map.put(c2[i], 1);
            } else {
                map.put(c2[i], map.get(c2[i]) + 1);
            }
        }
        List<String> ret = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key) == 1) {
                ret.add(key);
            }
        }
        return ret.toArray(new String[0]);
    }
}
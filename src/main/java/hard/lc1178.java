package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
// 1178. 猜字谜

public class lc1178 {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int mask = 0;
            for (int i = 0; i < w.length(); i++) {
                mask = mask | (1 << (w.charAt(i) - 'a'));
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        List<Integer> ret = new ArrayList<>();

        for (String puzzle : puzzles) {
            int mask = 0;
            for (int i = 1; i < puzzle.length(); i++) {
                mask = mask | (1 << (puzzle.charAt(i) - 'a'));
            }
            int temp = mask;
            int count = 0;
            do {
                int s = temp | (1 << (puzzle.charAt(0) - 'a'));
                if (map.containsKey(s)) {
                    count += map.get(s);
                }
                temp = (temp - 1) & mask;
            } while (temp != mask);
            ret.add(count);
        }

        return ret;
    }
}

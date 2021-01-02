package medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/dota2-senate/
// 649. Dota2参议院

public class lc649 {
    public String predictPartyVictory(String senate) {
        int length = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!d.isEmpty() && !r.isEmpty()) {
            int dIndex = d.poll();
            int rIndex = r.poll();
            if (dIndex < rIndex) {
                d.offer(dIndex + length);
            } else {
                r.offer(rIndex + length);
            }
        }

        return d.isEmpty() ? "Radiant" : "Dire";
    }
}

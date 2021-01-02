package medium;

import java.util.TreeSet;

// https://leetcode-cn.com/problems/exam-room/
// 855. 考场就座

public class ExamRoom {
    private TreeSet<Integer> set;
    private int max;

    public ExamRoom(int N) {
        this.set = new TreeSet<>();
        this.max = N - 1;
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        else {
            // first difference
            int dist = set.first();
            Integer prev = null;
            int inx = 0;
            for (int val : set) {
                if (prev != null) {
                    // difference
                    int diff = (val - prev) / 2;
                    if (diff > dist) {
                        dist = diff;
                        inx = diff + prev;
                    }
                }
                prev = val;
            }
            if (this.max - set.last() > dist) {
                inx = this.max;
            }
            set.add(inx);
            return inx;
        }
    }

    public void leave(int p) {
        set.remove(p);
    }
}

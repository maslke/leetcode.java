package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/ipo/
// 502. IPO
public class lc502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        Integer[][] arr = new Integer[len][2];
        for (int i = 0; i < len; i++) {
            arr[i] = new Integer[]{profits[i], capital[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        int inx = 0;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {

            while (inx < len && arr[inx][1] <= w) {
                queue.offer(arr[inx]);
                inx++;
            }
            if (!queue.isEmpty()) {
                w += queue.poll()[0];
            }
            else {
                break;
            }
        }
        return w;

    }
}

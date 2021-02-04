package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/find-median-from-data-stream/
// 295. 数据流的中位数

public class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue((Comparator<Integer>) (a, b) -> b.compareTo(a));
        large = new PriorityQueue((Comparator<Integer>) (a, b) -> a.compareTo(b));
    }

    public void addNum(int num) {
        if (small.isEmpty() || small.peek() >= num) {
            small.offer(num);
        }
        else {
            large.offer(num);
        }
        makeBalance();
    }

    private void makeBalance() {
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
        else if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        return (double) small.peek();
    }
}

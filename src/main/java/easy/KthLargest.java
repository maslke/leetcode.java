package easy;

import basic.MinHeap;

// https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
// 703. 数据流中的第K大元素

public class KthLargest {
    private MinHeap heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new MinHeap(10001);
        this.k = k;
        for (int n : nums) {
            insert(n);
        }
    }

    private void insert(int val) {

        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        insert(val);
        return heap.peek();
    }
}

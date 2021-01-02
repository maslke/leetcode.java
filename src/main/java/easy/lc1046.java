package easy;

import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;
// https://leetcode-cn.com/problems/last-stone-weight/
// 1046. 最后一块石头的重量

class lc1046 {

    static class MaxHeap {
        int[] values;
        int size;

        MaxHeap(int[] values) {
            this.values = new int[values.length + 1];
            this.size = 0;
            for (int v : values) {
                swim(this.values, v);
            }
        }

        public int poll() {
            int v = values[1];
            sink(values);
            return v;
        }

        public void offer(int v) {
            swim(values, v);
        }

        private void swap(int[] values, int i, int j) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }

        private void swim(int[] values, int v) {
            values[this.size + 1] = v;
            int i = this.size + 1;
            while (i >= 2 && values[i] > values[i / 2]) {
                swap(values, i, i / 2);
                i = i / 2;
            }
            this.size++;
        }

        private void sink(int[] values) {
            values[1] = values[this.size];
            int inx = 1;
            while (inx * 2 < this.size) {
                int j = inx * 2;
                if (j + 1 < this.size && values[j] < values[j + 1]) {
                    j++;
                }
                if (values[inx] >= values[j]) {
                    break;
                }
                swap(values, inx, j);
                inx = j;
            }
            this.size--;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }
    }

    public int lastStoneWeight(int[] stones) {
        MaxHeap heap = new MaxHeap(stones);
        while (heap.size() >= 2) {
            int a = heap.poll();
            int b = heap.poll();
            if (a != b) {
                heap.offer(a - b);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
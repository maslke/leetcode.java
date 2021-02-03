package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc480 {

    public static void main(String[] args) {
        lc480 lc = new lc480();
        double[] res = lc.medianSlidingWindow(new int[] {1,2,3,4}, 2);
        Arrays.stream(res).forEach(System.out::println);
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        DualHeap heap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(nums[i]);
        }
        res[0] = heap.getMedian();
        for (int i = k; i < nums.length; i++) {
            heap.insert(nums[i]);
            heap.remove(nums[i - k]);
            res[i - k + 1] = heap.getMedian();
        }
        return res;
    }

    class DualHeap {
        int k;
        Queue<Integer> small;
        Queue<Integer> big;
        int smallSize;
        int bigSize;
        Map<Integer, Integer> delayed;


        DualHeap(int k) {
            this.k = k;
            this.smallSize = 0;
            this.bigSize = 0;
            this.delayed = new HashMap<>();
            this.small = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
            this.big = new PriorityQueue<Integer>((o1, o2) -> o1.compareTo(o2));
        }

        double getMedian() {
            if (k % 2 == 0) {
                return ((double) small.peek() + big.peek()) / 2.0;
            }
            else {
                return (double) small.peek();
            }
        }

        void insert(int num) {
            if (small.isEmpty() || small.peek() >= num) {
                smallSize++;
                small.offer(num);
            }
            else {
                bigSize++;
                big.offer(num);
            }
            makeBalance();
        }

        void remove(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) {
                    prune(small);
                }
            }
            else {
                bigSize--;
                if (num == big.peek()) {
                    prune(big);
                }
            }
            makeBalance();
        }

        void prune(Queue<Integer> queue) {
            while (!queue.isEmpty()) {
                int num = queue.peek();
                if (delayed.containsKey(num)) {
                    int count = delayed.get(num);
                    if (count == 1) {
                        delayed.remove(num);
                    } else {
                        delayed.put(num, count - 1);
                    }
                    queue.poll();
                } else {
                    break;
                }
            }
        }

        void makeBalance() {
            if (smallSize > bigSize + 1) {
                smallSize--;
                bigSize++;
                big.offer(small.poll());
                prune(small);
            }
            else if (smallSize < bigSize) {
                bigSize--;
                smallSize++;
                small.offer(big.poll());
                prune(big);
            }
        }

    }
}

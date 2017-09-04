package medium;

/**
 * Author:maslke
 * Date:2017/9/4
 * Version:0.0.1
 * 215. Kth Largest Element in an Array
 * 优先级队列
 */
public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int[] pq = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pq[i + 1] = nums[i];
            swim(pq, i + 1);
        }
        int last = length;
        for (int i = 1; i < k; i++) {
            pq[1] = pq[last];
            pq[last] = 0;
            last--;
            sink(pq, 1, last);
        }
        return pq[1];
    }

    private void swim(int[] pq, int k) {
        while (pq[k / 2] < pq[k] && k > 1) {
            int temp = pq[k / 2];
            pq[k / 2] = pq[k];
            pq[k] = temp;
            k = k / 2;
        }
    }

    private void sink(int[] pq, int k, int last) {
        while (2 * k <= last) {
            int j = 2 * k;
            while (j < last && pq[j] < pq[j + 1]) {
                j++;
            }
            if (pq[k] < pq[j]) {
                int temp = pq[k];
                pq[k] = pq[j];
                pq[j] = temp;
            } else {
                break;
            }
            k = j;
        }
    }
}

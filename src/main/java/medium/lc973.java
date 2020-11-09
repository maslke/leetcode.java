package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
// 973. K Closest Points to Origin

class lc973 {
    public int[][] kCloset(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        queue.addAll(Arrays.asList(points));

        int[][] result = new int[K][2];
        int index = 0;
        while (K-- > 0) {
            result[index++] = queue.poll();
        }
        return result;
    }

    public int[][] kClosest2(int[][] points, int K) {
        int left = 0;
        int right= points.length - 1;
        int p;
        while (true) {
            p = partition(points, left, right);
            if (p == K - 1) {
                break;
            } else if (p > K - 1) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }

        // Arrays.copyOf();
        return Arrays.copyOf(points, K);
    }

    private int partition(int[][] points, int left, int right) {
        int[] m = points[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (less(points[++i], m)) {
                if (i == right) {
                    break;
                }
            }
            while (less(m, points[--j])) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(points, i, j);
        }
        swap(points, left, j);
        return j;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private boolean less(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] < b[0] * b[0] + b[1] * b[1];
    }
}
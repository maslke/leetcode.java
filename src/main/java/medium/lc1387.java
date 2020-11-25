package medium;


import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/sort-integers-by-the-power-value/
// 1387. 将整数按权重排序

public class lc1387 {
    Map<Integer, Integer> map;
    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        map.put(1, 0);
        int[] data = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            weight(i);
            data[i - lo] = i;
        }

        int i = 0;
        int j = data.length - 1;

        if (i == j) {
            return data[0];
        }

        while (true) {
            int p = partition(data, i, j);
            if (p == k - 1) {
                return data[p];
            } else if (p > k - 1) {
                j = p - 1;
            } else {
                i = p + 1;
            }
        }
    }

    private int partition(int[] data, int left, int right) {
        if (left == right) {
            return left;
        }
        int value = data[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (less(data[++i], value)) {
                if (i == right) {
                    break;
                }
            }
            while (less(value, data[--j])) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);
        }
        swap(data, left, j);
        return j;
    }

    private boolean less(int a, int b) {
        int w1 = map.get(a);
        int w2 = map.get(b);
        if (w1 == w2) {
            return a < b;
        }
        return w1 < w2;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int weight(int n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n % 2 == 0) {
            int weight = 1 + weight(n / 2);
            map.put(n, weight);
            return weight;
        } else {
            int weight = 1 + weight(n * 3 + 1);
            map.put(n, weight);
            return weight;
        }

    }
}

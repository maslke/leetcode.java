package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/pancake-sorting/
// 969. Pancake Sorting
class lc969 {

    public List<Integer> pancakeSort2(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int inx = max(arr, i, j);
            if (inx < j) {
                if (inx != 0) {
                    ret.add(inx + 1);
                    swap2(arr, i, inx);
                }
                if (j >= 1) {
                    ret.add(j + 1);
                    swap2(arr, 0, j);
                }


            }
            j--;
        }
        return ret;
    }

    private int max(int[] arr, int left, int right) {
        int max = 0;
        int inx = -1;
        for (int i = left; i <= right; i++) {
            if (max < arr[i]) {
                max = arr[i];
                inx = i;
            }
        }
        return inx;
    }

    private void swap2(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ret = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int c = 0;
        while (true) {
            int index = findMax(A, set);
            if (index == -1) break;
            set.add(A[index]);
            reverse(A, index);
            ret.add(index + 1);
            index = A.length - 1 - c;
            reverse(A, index);
            c++;
            ret.add(index + 1);
        }
        return ret;
    }

    private int findMax(int[] A, Set<Integer> set) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (!set.contains(v)) {
                if (v > max) {
                    max = v;
                    index = i;
                }
            }
        }
        return index;
    }

    private void reverse(int[] A, int k) {
        int i = 0;
        int j = k;
        while (i <= j) {
            swap(A, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
package medium;

import java.util.Set;
import java.util.HashSet;

class lc1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                flags[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                flags[rightChild[i]] = true;
            }
        }
        
        int root = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                root = i;
                count++;
            }
        }
        if (count > 1) return false;
        Set<Integer> set = new HashSet<>();
        set.add(root);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && set.contains(leftChild[i])) {
                return false;
            }
            if (rightChild[i] != -1 && set.contains(rightChild[i])) {
                return false;
            }
            set.add(leftChild[i]);
            set.add(rightChild[i]);
        }
        return true;
    }
}
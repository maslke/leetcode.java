package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

// https://leetcode-cn.com/problems/validate-binary-tree-nodes/
// 1361. 验证二叉树

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
        int inx = 0;
        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                root++;
                inx = i;
            }
        }

        if (root == 0 || root > 1) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(inx);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (visited.contains(index)) {
                    return false;
                }
                visited.add(index);
                count++;
                if (leftChild[index] != -1) {
                    queue.offer(leftChild[index]);
                }
                if (rightChild[index] != -1) {
                    queue.offer(rightChild[index]);
                }
            }
        }

        return count == n;
    }
}
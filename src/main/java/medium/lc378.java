package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// 378. Kth Smallest Element in a Sorted Matrix

class lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        
        for (int i = 0; i < matrix[0].length; i++) {
            queue.offer(new Node(0, i, matrix[0][i]));
        }
        
        while (true) {
            Node node = queue.poll();
            k--;
            if (k == 0) {
                return node.val;
            }
            if (node.i < matrix.length - 1) {
                queue.offer(new Node(node.i + 1, node.j, matrix[node.i + 1][node.j]));
            }
        }
        
    }
}

class Node {
    int i;
    int j;
    int val;
    Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
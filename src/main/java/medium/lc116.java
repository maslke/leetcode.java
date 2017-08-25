package medium;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 */
public class lc116 {
    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode left, TreeLinkNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left == null) {
            connect(right.left, right.right);
        }
        if (right == null) {
            connect(left.left, left.left);
        }

        left.next = right;
        connect(left.left, left.right);
        connect(left.right, right.left);
        connect(right.left, right.right);

    }
}

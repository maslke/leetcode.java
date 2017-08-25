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
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Queue<TreeLinkNode> innerQueue = new LinkedList<TreeLinkNode>();
            TreeLinkNode cur = new TreeLinkNode(0);
            while(!queue.isEmpty()) {
                TreeLinkNode temp = queue.poll();
                cur.next = temp;
                cur = temp;
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            queue = innerQueue;
        }
    }
}

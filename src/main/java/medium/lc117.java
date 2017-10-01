package medium;

/**
 * Author:maslke
 * Date:2017/10/1
 * Version:0.0.1
 * 117. Populating Next Right Pointers in Each Node II
 * 合理利用上一层遍历的结果
 */
public class lc117 {
    class TreeLinkNode {
        TreeLinkNode left, next, right;
        int val;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode prev = null,head = null;
        TreeLinkNode temp = root;
        while (temp != null) {
            while (temp != null) {
                if (temp.left != null) {
                    if (prev == null) {
                        head = temp.left;
                        prev = head;
                    } else {
                        prev.next = temp.left;
                        prev = prev.next;
                    }
                }
                if (temp.right != null) {
                    if (prev == null) {
                        head = temp.right;
                        prev = head;
                    } else {
                        prev.next = temp.right;
                        prev = prev.next;
                    }
                }
                temp = temp.next;
            }
            temp = head;
            prev = null;
            head = null;
        }
    }
}

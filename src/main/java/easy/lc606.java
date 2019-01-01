
/**
 * Author:maslke
 * Date:2017/8/19
 * Version:0.0.1
 * 606. Construct String from Binary Tree
 */
public class lc606 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        if (t.left != null && t.right != null) {
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
        }
        if (t.left != null) {
            return t.val + "(" + tree2str(t.left) + ")";
        } else {
            return t.val + "()(" + tree2str(t.right) + ")";
        }
    }

}

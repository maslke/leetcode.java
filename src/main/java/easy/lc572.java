package easy;

/**
 * Author:maslke
 * Date:2017/9/30
 * Version:0.0.1
 * 572. Subtree of Another Tree
 */
public class lc572 {
    class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            if (subtree(s, t)) {
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean subtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return subtree(s.left, t.left) && subtree(s.right, t.right);
    }
}

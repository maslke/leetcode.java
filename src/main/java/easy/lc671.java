package easy;

// https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
// 671. 二叉树中第二小的节点

import basic.TreeNode;

public class lc671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        if (root.left.val == root.right.val) {
            int v1 = findSecondMinimumValue(root.left);
            int v2 = findSecondMinimumValue(root.right);
            if (v1 == -1) {
                return v2;
            }
            if (v2 == -1) {
                return v1;
            }
            return Math.min(v1, v2);
        }
        else {
            if (root.val == root.left.val) {
                int v = findSecondMinimumValue(root.left);
                if (v == -1) {
                    return root.right.val;
                }
                return Math.min(v, root.right.val);
            }
            else {
                int v = findSecondMinimumValue(root.right);
                if (v == -1) {
                    return root.left.val;
                }
                return Math.min(v, root.left.val);
            }
        }
    }
}

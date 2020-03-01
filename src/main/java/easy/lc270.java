package easy;

// https://leetcode-cn.com/problems/closest-binary-search-tree-value/
// 270. 最接近的二叉搜索数值

class lc270 {
    public int closestValue(TreeNode root, double target) {
        int v = root.val;
        if (target > v) {
            if (root.right == null) return root.val;
            TreeNode temp = findLeft(root.right);
            int right = temp.val;
            if (Math.abs(right - target) > Math.abs(target - v)) {
                return root.val;
            } else {
                return closestValue(root.right, target);
            }

        } else if (target < v) {
            if (root.left == null) return root.val;
            TreeNode temp = findRight(root.left);
            int left = temp.val;
            if (Math.abs(left -target) > Math.abs(target - v)) {
                return root.val;
            } else {
                return closestValue(root.left, target);
            }
        } else {
            return root.val;
        }
    }

    private TreeNode findRight(TreeNode node) {
        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private TreeNode findLeft(TreeNode node) {
        TreeNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
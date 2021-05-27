package medium;

// https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
// 421. 数组中两个数的最大异或值
public class lc421 {

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        void insert(int num) {
            TreeNode node = this;
            for (int i = 31; i >= 0; i--) {
                int a = (num >> i) & 1;
                if (a == 1) {
                    if (node.right == null) {
                        node.right = new TreeNode();
                    }
                    node = node.right;
                }
                else {
                    if (node.left == null) {
                        node.left = new TreeNode();
                    }
                    node = node.left;
                }
            }
        }

        int maxXor(int num) {
            TreeNode node = this;
            int v = 0;
            for (int i = 31; i >= 0; i--) {
                if (node.left == null && node.right == null) {
                    return -1;
                }
                int a = (num >> i) & 1;
                if (a == 1) {
                    if (node.left != null) {
                        v = (v << 1) + 1;
                        node = node.left;
                    }
                    else {
                        v = (v << 1);
                        node = node.right;
                    }
                }
                else {
                    if (node.right != null) {
                        v = (v << 1) + 1;
                        node = node.right;
                    }
                    else {
                        v = (v << 1);
                        node = node.left;
                    }
                }
            }
            return v;
        }
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        TreeNode root = new TreeNode();
        root.insert(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, root.maxXor(nums[i]));
            root.insert(nums[i]);
        }
        return max;
    }
}

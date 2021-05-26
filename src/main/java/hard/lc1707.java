package hard;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
// 1707. 与数组中元素的最大异或值

public class lc1707 {
    class TreeNode {
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        void insert(int num) {
            TreeNode node = this;
            for (int j = 31; j >= 0; j--) {
                int v = (num >> j) & 1;
                if (v == 0) {
                    if (node.left == null) {
                        node.left = new TreeNode();
                    }
                    node = node.left;
                }
                else {
                    if (node.right == null) {
                        node.right = new TreeNode();
                    }
                    node = node.right;
                }
            }
        }

        private int maxXor(int num) {
            TreeNode node = this;
            int v = 0;
            for (int j = 31; j >= 0; j--) {
                if (node.left == null && node.right == null) {
                    return -1;
                }
                int a = (num >> j) & 1;
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

    public int[] maximizeXor(int[] nums, int[][] queries) {
        TreeNode root = new TreeNode();

        int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(q, Comparator.comparingInt(o -> o[1]));
        int[] ret = new int[q.length];
        int inx = 0;
        for (int i = 0; i < q.length; i++) {
            while (inx < nums.length && nums[inx] <= q[i][1]) {
                root.insert(nums[inx]);
                inx++;
            }
            ret[q[i][2]] = root.maxXor(q[i][0]);

        }

        return ret;
    }
}

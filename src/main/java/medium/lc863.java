package medium;

import basic.TreeNode;

import java.util.*;

// https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
// 863. 二叉树中所有距离为 K 的结点
public class lc863 {


    Map<Integer, TreeNode> map = new HashMap<>();
    List<Integer> ret = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        compose(root, null);
        rec(target, null, 0, k);
        return ret;
    }

    private void compose(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node.val, parent);
        compose(node.left, node);
        compose(node.right ,node);
    }

    private void rec(TreeNode node ,TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ret.add(node.val);
            return;
        }
        if (node.left != from) {
            rec(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            rec(node.right, node, depth + 1, k);
        }
        if (map.get(node.val) != from) {
            rec(map.get(node.val), node, depth + 1, k);
        }
    }


}

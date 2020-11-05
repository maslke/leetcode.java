package medium;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class lc1110 {


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        for (int i = 0; i < to_delete.length; i++) {
            int v = to_delete[i];
            int size = nodes.size();
            for (int inx = 0; inx < size; inx++) {
                TreeNode node = nodes.get(0);
                for (TreeNode tn : delNodes(node, v)) {
                    nodes.add(tn);
                }
                nodes.remove(0);
            }
        }
        return nodes;
    }

    private List<TreeNode> delNodes(TreeNode root, int a) {
        List<TreeNode> result = new ArrayList<>();
        if (root.val == a) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, TreeNode> leftMap = new HashMap<>();
        Map<TreeNode, TreeNode> rightMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn.val == a) {
                    result.add(root);
                    if (leftMap.containsKey(tn)) {
                        leftMap.get(tn).left = null;
                    }
                    if (rightMap.containsKey(tn)) {
                        rightMap.get(tn).right = null;
                    }

                    if (tn.left == null && tn.right == null) {
                        return result;
                    }

                    if (tn.left != null) {
                        result.add(tn.left);
                        tn.left = null;
                    }
                    if (tn.right != null) {
                        result.add(tn.right);
                        tn.right = null;
                    }
                    return result;
                }

                if (tn.left != null) {
                    queue.offer(tn.left);
                    leftMap.put(tn.left, tn);
                }
                if (tn.right != null) {
                    queue.offer(tn.right);
                    rightMap.put(tn.right, tn);
                }
            }
        }
        if (result.isEmpty()) {
            result.add(root);
        }
        return result;
    }
}
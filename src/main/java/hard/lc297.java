package hard;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//297. Serialize and Deserialize Binary Tree
// solution one : TLE
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class lc297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb2 = new StringBuilder();
            boolean alwaysNull = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    alwaysNull = false;
                    queue.add(node.left);
                    queue.add(node.right);
                    sb2.append(",").append(node.val);
                } else {
                    queue.add(null);
                    queue.add(null);
                    sb2.append(",null");
                }
            }
            if (!alwaysNull) {
                sb.append(sb2.toString());
            } else {
                queue.clear();
            }
        }

        String ret = sb.toString();
        return ret.substring(1, ret.length());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals(""))
            return null;
        String[] c = data.split(",");
        TreeNode[] nodes = new TreeNode[c.length];
        for (int i = 0; i < c.length; i++) {
            if (!c[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.valueOf(c[i]));
                if (i >= 1) {
                    if (i % 2 == 0) {
                        nodes[(i - 1) / 2].right = nodes[i];
                    } else {
                        nodes[(i - 1) / 2].left = nodes[i];
                    }
                }
            }
        }
        return nodes[0];
    }

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize2(root, sb);
        String ret = sb.toString();
        return ret.substring(1, ret.length());
    }

    private void serialize2(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",null");
        } else {
            sb.append(",").append(node.val);
            serialize2(node.left, sb);
            serialize2(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] c = data.split(",");
        List<String> contents = new LinkedList<String>(Arrays.asList(c));
        return deserialize2(contents);
    }

    private TreeNode deserialize2(List<String> contents) {
        if (contents.get(0).equals("null")) {
            contents.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(contents.get(0)));
        contents.remove(0);
        root.left = deserialize2(contents);
        root.right = deserialize2(contents);
        return root;
    }
}
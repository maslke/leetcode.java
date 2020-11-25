package medium;

import basic.TreeNode;

// https://leetcode.com/problems/serialize-and-deserialize-bst/
// 449. Serialize and Deserialize BST
public class lc449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String ret = sb.toString();
        return ret.substring(0, ret.length() - 1);
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        sb.append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] nums = data.split(",");
        int[] values = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = Integer.parseInt(nums[i]);
        }
        return des(values, 0, values.length - 1);
    }
    
    private TreeNode des(int[] values, int begin, int end) {
        if (begin > end) return null;
        int val = values[begin];
        TreeNode root = new TreeNode(val);
        int index = -1;
        for (int i = begin + 1; i <= end; i++) {
            if (values[i] > val) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            root.left = des(values, begin + 1, end);
        } else {
            root.left = des(values, begin + 1, index - 1);
            root.right = des(values, index, end);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
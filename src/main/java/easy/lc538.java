package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 538. Convert BST to Greater Tree
 */
public class lc538 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack =new Stack<TreeNode>();
        stack.push(root);
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            nodeList.add(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        Map<TreeNode, Integer> map = getGreaterValue(nodeList);
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).val = map.get(nodeList.get(i));
        }
        return root;
    }

    private Map<TreeNode, Integer> getGreaterValue(List<TreeNode> nodeList) {
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        for (int i = 0; i < nodeList.size(); i++) {
            int sum = 0;
            for (int j = 0; j < nodeList.size(); j++) {
                if (nodeList.get(i).val <= nodeList.get(j).val) {
                    sum += nodeList.get(j).val;
                }
            }
            map.put(nodeList.get(i), sum);
        }
        return map;
    }
}

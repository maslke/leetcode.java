package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/9/10
 * Version:0.0.1
 * 437. Path Sum III
 */
public class lc437 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public int pathSum(TreeNode root, int sum) {
        return getCount(root, sum);
    }

    private int getCount(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int v = count(node, sum);
        int v1 = getCount(node.left, sum);
        int v2 = getCount(node.right, sum);
        return v + v1 + v2;
    }

    private int count(TreeNode node, int sum) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(node, node.val);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            int val = map.get(temp);
            if (val == sum) {
                count++;
            }
            if (temp.left != null) {
                map.put(temp.left, temp.left.val + val);
                stack.push(temp.left);
            }
            if (temp.right != null) {
                map.put(temp.right, temp.right.val + val);
                stack.push(temp.right);
            }
        }
        return count;
    }
}

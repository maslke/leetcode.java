
/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 112. Path Sum
 */
public class lc112 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        map.put(root, root.val);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                if (map.get(temp) == sum) {
                    return true;
                }
            }
            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, map.get(temp) + temp.right.val);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, map.get(temp) + temp.left.val);
            }
        }
        return false;
    }
}

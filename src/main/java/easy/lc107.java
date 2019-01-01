/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 107. Binary Tree Level Order Traversal II
 */
public class lc107 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            List<Integer> level = new ArrayList<Integer>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            stack.push(level);
            queue = innerQueue;
        }
        while(!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}

package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//589. N-ary Tree Preorder Traversal
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class lc589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ret.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return ret;
    }
}
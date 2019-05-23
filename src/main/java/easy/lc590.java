package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
// 590. N-ary Tree Postorder Traversal
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
class lc590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (set.contains(node)) {
                ret.add(node.val);
            } else {
                stack.push(node);
                set.add(node);
                List<Node> nodes = node.children;
                for (int i = nodes.size() - 1; i >= 0; i--) {
                    stack.push(nodes.get(i));
                }
                
            }
        }
        return ret;
    }
}
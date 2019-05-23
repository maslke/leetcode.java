package easy;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//559. Maximum Depth of N-ary Tree
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
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (int i = 0;i < root.children.size(); i++) {
            int v = maxDepth(root.children.get(i));
            if (v > max) {
                max = v;
            }
        }
        return max + 1;
    }
}
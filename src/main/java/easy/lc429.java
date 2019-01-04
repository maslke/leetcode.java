//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
//429. N-ary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                }
                inner.add(node.val);
            }
            ret.add(inner);
        }
        return ret;
    }
}
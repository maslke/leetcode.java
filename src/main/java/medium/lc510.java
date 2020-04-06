package medium;

import java.util.HashSet;
import java.util.Set;

//
//


// Definition for a Node.


class lc510 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    Set<Node> set = new HashSet<>();

    public Node inorderSuccessor(Node node) {
        if (node == null) return null;
        set.add(node);
        if (node.right != null && !set.contains(node.right)) return left(node.right);
        set.add(node.right);
        Node parent = node.parent;
        if (parent == null) return null;
        if (parent.val < node.val) {
            return inorderSuccessor(parent);
        }   else {
            return parent;
        } 
    }

    private Node left(Node node) {
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
package medium;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
// 1305. All Elements in Two Binary Search Tree

class lc1305 {

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode p1 = root1;
        TreeNode p2 = root2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.left;
        }    
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.left;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> stack = null;
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                int v1 = stack1.peek().val;
                int v2 = stack2.peek().val;
                if (v1 < v2) {
                    ret.add(v1);
                    stack = stack1;
                } else {
                    ret.add(v2);
                    stack = stack2;
                }
            } else if (!stack1.isEmpty()) {
                ret.add(stack1.peek().val);
                stack = stack1;
            } else if (!stack2.isEmpty()) {
                ret.add(stack2.peek().val);
                stack = stack2;
            }

            TreeNode node = stack.pop();
            TreeNode p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }

        return ret;
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        visit(root1, list1);
        visit(root2, list2);
        int i = 0;
        int j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size() && j < list2.size()) {
                if (list1.get(i) <= list2.get(j)) {
                    list3.add(list1.get(i));
                    i++;
                } else {
                    list3.add(list2.get(j));
                    j++;
                }
            } else if (i < list1.size()) {
                list3.add(list1.get(i));
                i++;
            } else if (j < list2.size()) {
                list3.add(list2.get(j));
                j++;
            }
        }
        return list3;
    }

    private void visit(TreeNode node, List<Integer> list) {
        if (node == null) return;
        visit(node.left, list);
        list.add(node.val);
        visit(node.right, list);
    }
}
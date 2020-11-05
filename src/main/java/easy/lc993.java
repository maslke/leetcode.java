package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class lc993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(root.val, null);
        map2.put(root.val, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                
                if (node.left != null) {
                    queue.offer(node.left);
                    map1.put(node.left.val, node);
                    map2.put(node.left.val, map2.get(node.val) + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map1.put(node.right.val, node);
                    map2.put(node.right.val, map2.get(node.val) + 1);
                }
            }
        }
        
        return map2.get(x) == map2.get(y) && map1.get(x) != map1.get(y);
    }


    public boolean isCousins2(TreeNode root, int x, int y) {
        Map<TreeNode, TreeNode> map1 = new HashMap<>();
        map1.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean xExists = false;
            boolean yExists = false;
            TreeNode xParent = null;
            TreeNode yParent = null;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                if (node.val == x) {
                    xExists = true;
                    xParent = map1.get(node);
                }
                if (node.val == y) {
                    yExists = true;
                    yParent = map1.get(node);
                }  
                
                if (node.left != null) {
                    queue.offer(node.left);
                    map1.put(node.left, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map1.put(node.right, node);
                }
            }
            if (xExists && yExists && xParent != yParent) {
                    return true;
                }
        }
        
        return false;
    }
    
}
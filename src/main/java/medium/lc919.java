package medium;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/complete-binary-tree-inserter/
// 919. Complete Binary Tree Inserter

class CBTInserter {

    private TreeNode root;
    private List<TreeNode> last;
    private int inx;
    private int level;
    private boolean inited;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        this.last = new ArrayList<>();
        this.level = 0;
        this.inx = 0;
        this.inited = false;
    }
    
    private void init() {
        inited = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> prev = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                prev.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            if (queue.size() != Math.pow(2, this.level)) {
                last = prev;
                this.inx = queue.size();
                break;
            }
        }
    }
    
    public int insert(int v) {
        if (!inited) {
            init();
        }  
        if (inx == Math.pow(2, level)) {
            List<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < last.size(); i++) {
                TreeNode node = last.get(i);
                if (node.left != null) {
                    temp.add(node.left);
                    if (node.right != null) {
                        temp.add(node.right);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            last = temp;
            level++;
            inx = 0;
            return insert(v);
            
        } else {
            if (inx % 2 == 0) {
                last.get(inx / 2).left = new TreeNode(v);
            } else {
                last.get(inx / 2).right = new TreeNode(v);
            }
            inx++;
            return last.get((inx - 1) / 2).val;
        }
    }
    
    public TreeNode get_root() {
        return this.root;    
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
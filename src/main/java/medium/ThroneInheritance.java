package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/throne-inheritance/
// 1600. 皇位继承顺序

public class ThroneInheritance {

    private class TreeNode {
        String name;
        boolean alive;
        List<TreeNode> children;

        TreeNode(String name) {
            this.name = name;
            this.alive = true;
            this.children = new ArrayList<>();
        }

        String getName() {
            return this.name;
        }

        List<TreeNode> getChildren() {
            return this.children;
        }

        void setAlive(boolean alive) {
            this.alive = alive;
        }

        boolean getAlive() {
            return this.alive;
        }
    }

    private class Tree {
        TreeNode root;
        Map<String, TreeNode> map;

        Tree(String name) {
            this.root = new TreeNode(name);
            this.map = new HashMap<>();
            this.map.put(name, this.root);
        }

        TreeNode findNode(String name) {
            return findNode(name, this.root);
        }

        private TreeNode findNode(String name, TreeNode node) {
            if (this.map.containsKey(name)) {
                return this.map.get(name);
            }
            if (node.getName().equals(name)) {
                this.map.put(name, node);
                return node;
            } else {
                for (TreeNode tn : node.getChildren()) {
                    TreeNode res = findNode(name, tn);
                    if (res != null) {
                        this.map.put(name, res);
                        return res;
                    }
                }
            }
            return null;
        }

        void appendChild(TreeNode parent, String name) {
            TreeNode node = new TreeNode(name);
            this.map.put(name, node);
            parent.getChildren().add(node);
        }

        List<String> getOrder() {
            List<String> list = new ArrayList<>();
            preorder(this.root, list);
            return list;
        }

        void preorder(TreeNode root, List<String> list) {
            if (root.getAlive()) {
                list.add(root.getName());
            }
            for (TreeNode node : root.getChildren()) {
                preorder(node, list);
            }
        }
    }

    private Tree tree;

    public ThroneInheritance(String kingName) {
        this.tree = new Tree(kingName);
    }

    public void birth(String parentName, String childName) {
        TreeNode node = this.tree.findNode(parentName);
        this.tree.appendChild(node, childName);
    }

    public void death(String name) {
        TreeNode node = this.tree.findNode(name);
        if (node != null) {
            node.setAlive(false);
        }
    }

    public List<String> getInheritanceOrder() {
        return this.tree.getOrder();
    }
}

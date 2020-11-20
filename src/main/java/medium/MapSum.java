package medium;

// https://leetcode-cn.com/problems/map-sum-pairs/
// 677. 键值映射

public class MapSum {
    class TrieNode {
        int val;
        Character ch;
        boolean end;
        TrieNode[] children;

        TrieNode(char ch) {
            this.ch = ch;
            this.children = new TrieNode[26];
        }

        boolean contains(char ch) {
            return this.children[ch - 'a'] != null;
        }

        TrieNode add(char ch) {
            this.children[ch - 'a'] = new TrieNode(ch);
            return this.children[ch - 'a'];
        }

        TrieNode getNode(char ch) {
            return this.children[ch - 'a'];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode(' ');
    }

    public void insert(String key, int val) {
        TrieNode node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (node.contains(ch)) {
                node = node.getNode(ch);
            } else {
                node = node.add(ch);
            }
        }
        node.end = true;
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.contains(ch)) {
                node = node.getNode(ch);
            } else {
                return 0;
            }
        }

        return sum(node);
    }

    private int sum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int val = 0;
        if (node.end) {
            val += node.val;
        }
        for (TrieNode child : node.children) {
            val += sum(child);
        }
        return val;
    }
}

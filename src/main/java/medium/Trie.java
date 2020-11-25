package medium;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
// 208. 实现Trie(前缀树)

public class Trie {

    class TrieNode {
        Character val;

        TrieNode[] nodes;

        boolean end;

        TrieNode(Character ch) {
            this.val = ch;
            this.nodes = new TrieNode[26];
            this.end = false;
        }

        void setEnd(boolean end) {
            this.end = end;
        }

        boolean getEnd() {
            return this.end;
        }

        public TrieNode getNode(Character chr) {
            if (contains(chr)) {
                return this.nodes[chr - 'a'];
            } else {
                return null;
            }
        }

        public boolean contains(Character chr) {
            return this.nodes[chr - 'a'] != null;
        }

        public TrieNode add(Character chr) {
            this.nodes[chr - 'a'] = new TrieNode(chr);
            return this.nodes[chr - 'a'];
        }


    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.getNode(word.charAt(i));
            } else {
                node = node.add(word.charAt(i));
            }
            if (i == word.length() - 1) {
                node.setEnd(true);
            }
        }
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.getNode(word.charAt(i));
            } else {
                return null;
            }
        }
        return node;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

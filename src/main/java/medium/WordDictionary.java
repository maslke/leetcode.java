package medium;

// https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
// 211. 添加与搜索单词——数据结构设计

public class WordDictionary {

    class TrieNode {
        Character val;
        TrieNode[] children;
        boolean end;

        TrieNode(Character ch) {
            this.val = ch;
            this.children = new TrieNode[26];
            this.end = false;
        }

        TrieNode add(Character ch) {
            this.children[ch - 'a'] = new TrieNode(ch);
            return this.children[ch - 'a'];
        }

        boolean contains(Character ch) {
            return this.children[ch - 'a'] != null;
        }

        TrieNode getNode(Character ch) {
            return this.children[ch - 'a'];
        }

        boolean getEnd() {
            return this.end;
        }

        void setEnd(boolean end) {
            this.end = end;
        }


    }

    TrieNode root;


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.contains(ch)) {
                node = node.getNode(ch);
            } else {
                node = node.add(ch);
            }
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    boolean search(TrieNode node, String word, int inx) {
        if (node == null) {
            return false;
        }
        if (inx == word.length()) {
            return node.getEnd();
        }
        char ch = word.charAt(inx);
        if (ch == '.') {
            TrieNode[] children = node.children;
            for (TrieNode tn : children) {
                boolean ret = search(tn, word, inx + 1);
                if (ret) {
                    return true;
                }
            }
        } else {
            if (!node.contains(ch)) {
                return false;
            }
            return search(node.getNode(ch), word, inx + 1);
        }

        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

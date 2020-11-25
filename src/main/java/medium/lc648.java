package medium;

import java.util.List;

// https://leetcode-cn.com/problems/replace-words/
// 648. 单词替换

public class lc648 {
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean end;

        TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
        }

        boolean contains(char c) {
            return this.children[c - 'a'] != null;
        }

        TrieNode getNode(char c) {
            return this.children[c - 'a'];
        }

        TrieNode add(char c) {
            TrieNode node = new TrieNode(c);
            this.children[c - 'a'] = node;
            return node;
        }

        String find(String word, int inx) {
            if (inx == word.length()) {
                return "";
            }
            TrieNode[] children = this.children;
            for (TrieNode child : children) {
                if (child != null && child.val == word.charAt(inx)) {
                    if (child.end) {
                        return String.valueOf(child.val);
                    } else {
                        String ret = child.find(word, inx + 1);
                        if (ret.equals("")) {
                            return "";
                        }
                        return child.val + ret;
                    }
                }

            }
            return "";
        }
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode(' ');
        for (String dict : dictionary) {
            TrieNode node = this.root;
            for (int i = 0; i < dict.length(); i++) {
                char c = dict.charAt(i);
                if (node.contains(c)) {
                    node = node.getNode(c);
                } else {
                    node = node.add(c);
                }
            }
            node.end = true;
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String ret = this.root.find(word, 0);
            if (ret.equals("")) {
                ret = word;
            }
            sb.append(' ').append(ret);
        }
        return sb.toString().substring(1);
    }
}

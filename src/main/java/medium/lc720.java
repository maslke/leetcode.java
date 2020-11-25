package medium;

// https://leetcode-cn.com/problems/longest-word-in-dictionary/
// 720. 词典中最长的单词

public class lc720 {

    class TrieNode {
        boolean end;
        TrieNode[] children;
        char val;

        TrieNode(char ch) {
            this.val = ch;
            this.children = new TrieNode[26];
        }

        boolean contains(char ch) {
            return this.children[ch - 'a'] != null;
        }

        TrieNode add(char ch) {
            TrieNode node = new TrieNode(ch);
            this.children[ch - 'a'] = node;
            return node;
        }

        TrieNode getNode(char ch) {
            return this.children[ch - 'a'];
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode(' ');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode node = root;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (node.contains(ch)) {
                    node = node.getNode(ch);
                }
                else {
                    node = node.add(ch);
                }
            }
            node.end = true;
        }
        return longest(root);

    }

    private String longest(TrieNode node) {
        TrieNode[] children = node.children;
        int max = 0;
        String result = "";
        for (int i = 0; i < children.length; i++) {
            TrieNode tn = children[i];
            if (tn == null || !tn.end) {
                continue;
            }
            String str = longest(tn);
            if (1 + str.length() > max) {
                max = 1 + str.length();
                result = tn.val + str;
            }
        }
        return result;
    }

}

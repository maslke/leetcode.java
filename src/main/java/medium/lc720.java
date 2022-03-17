package medium;

// https://leetcode-cn.com/problems/longest-word-in-dictionary/
// 720. 词典中最长的单词

public class lc720 {


    static class TrieNode {
        TrieNode[] children;
        boolean end;
        char val;
        TrieNode(char ch) {
            val = ch;
            children = new TrieNode[26];
        }

        TrieNode insert(char c) {
            if (children[c - 'a'] != null) {
                return children[c - 'a'];
            }
            children[c - 'a'] = new TrieNode(c);
            return children[c - 'a'];
        }

        boolean add(String w) {
            TrieNode node = this;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                node = node.insert(c);
            }
            node.end = true;
            return true;
        }

        boolean exists(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c=  word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
                if (!node.end) {
                    return false;
                }
            }
            return node.end;
        }


    }

    public String longestWord(String[] words) {
        TrieNode node  = new TrieNode(' ');
        for (String w : words) {
            node.add(w);
        }

        String ret = "";
        for (String w : words) {
            if (node.exists(w) && (ret.length() < w.length() || (ret.length() == w.length() && ret.compareTo(w) > 0))) {
                ret = w;
            }
        }
        return ret;

    }

}




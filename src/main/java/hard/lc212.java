package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/word-search-ii/
// 212. 单词搜索 II

public class lc212 {

    private Set<String> set;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {

        trie = new Trie();
        for (String word : words) {
            trie.insert(word);

        }
        set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(trie.root, board, i, j);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(TrieNode node, char[][] chars, int i, int j) {

        if (i < 0 || j < 0 || i >= chars.length || j >= chars[i].length) {
            return;
        }
        if (chars[i][j] == '+') {
            return;
        }

        char ch = chars[i][j];
        TrieNode tn = node.children[ch - 'a'];
        if (tn == null) {
            return;
        }
        if (tn.getEnd()) {
            set.add(tn.getWord());
        }


        char temp = chars[i][j];
        chars[i][j] = '+';

        dfs(tn, chars, i + 1, j);
        dfs(tn, chars, i - 1, j);
        dfs(tn, chars, i, j + 1);
        dfs(tn, chars, i, j - 1);

        chars[i][j] = temp;
    }

    class TrieNode {
        char chr;
        boolean end;
        TrieNode[] children;
        String word;

        TrieNode(char ch, boolean end) {
            this.chr = ch;
            this.end = end;
            this.children = new TrieNode[26];
        }

        void setEnd(boolean end) {
            this.end = end;
        }

        boolean getEnd() {
            return this.end;
        }

        void setWord(String word) {
            this.word = word;
        }

        String getWord() {
            return this.word;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode(' ', false);
        }

        void insert(String word) {
            TrieNode[] children = root.children;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = children[ch - 'a'];
                if (node == null) {
                    children[ch - 'a'] = new TrieNode(ch, false);
                    node = children[ch - 'a'];
                }
                if (i == word.length() - 1) {
                    node.setEnd(true);
                    node.setWord(word);
                }
                children = node.children;
            }
        }

    }
}

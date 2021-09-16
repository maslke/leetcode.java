package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, i, j, visited, new StringBuilder());
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] chars, int i, int j, boolean[][] visited, StringBuilder sb) {

        if (sb.length() > 0) {
            if (!trie.startWith(sb.toString())) {
                return;
            }
            if (trie.contains(sb.toString())) {
                set.add(sb.toString());
            }
        }

        if (i < 0 || j < 0 || i >= chars.length || j >= chars[i].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }



        visited[i][j] = true;
        sb.append(chars[i][j]);

        dfs(chars,i + 1, j, visited, sb);
        dfs(chars, i - 1, j, visited, sb);
        dfs(chars, i, j + 1, visited, sb);
        dfs(chars, i, j - 1, visited, sb);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    class TrieNode {
        char chr;
        boolean end;
        TrieNode[] children;

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

        boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode(' ', false);
        }

        boolean contains(String word) {
            TrieNode[] children = root.children;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (children[ch - 'a'] == null) {
                    return false;
                }

                if (i == word.length() - 1) {
                    return children[ch - 'a'].getEnd();
                }

                children = children[ch - 'a'].children;
            }
            return false;
        }

        boolean startWith(String word) {
            TrieNode[] children = root.children;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (children[ch - 'a'] == null) {
                    return false;
                }
                children = children[ch - 'a'].children;
            }
            return true;
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
                }
                children = node.children;
            }
        }

    }

    public static void main(String[] args) {
        char[][] chars = {{'a'}};
        String[] words = {"a"};
        lc212 instance = new lc212();
        List<String> ret = instance.findWords(chars, words);
    }
}

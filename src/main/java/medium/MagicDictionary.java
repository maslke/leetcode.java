package medium;

// leetcode-676

public class MagicDictionary {

    class TrieNode {
        Character val;
        TrieNode[] children;
        boolean end;

        TrieNode(Character value) {
            this.val = value;
            this.children = new TrieNode[26];
            this.end = false;
        }

        boolean contains(Character val) {
            return this.children[val - 'a'] != null;
        }

        TrieNode add(Character val) {
            if (!contains(val)) {
                TrieNode node = new TrieNode(val);
                this.children[val - 'a'] = node;
                return node;
            } else {
                return null;
            }
        }

        boolean getEnd() {
            return this.end;
        }

        void setEnd(boolean end) {
            this.end = end;
        }

        TrieNode getNode(Character ch) {
            return this.children[ch - 'a'];
        }


    }

    TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        this.root = new TrieNode(' ');
    }

    public void buildDict(String[] dictionary) {
        for (String dict : dictionary) {
            build(dict);
        }
    }

    private void build(String dict) {
        TrieNode node = this.root;
        for (int i = 0; i < dict.length(); i++) {
            char ch = dict.charAt(i);
            if (node.contains(ch)) {
                node = node.getNode(ch);
            } else {
                node = node.add(ch);
            }
        }
        node.setEnd(true);
    }

    public boolean search(String searchWord) {
        return search(this.root, searchWord, 0, 0);
    }

    private boolean search(TrieNode node, String searchWord, int inx, int count) {
        if (inx == searchWord.length()) {
            return count == 1 && node.getEnd();
        }
        if (count > 1) {
            return false;
        }
        char ch = searchWord.charAt(inx);

        for (TrieNode temp : node.children) {
            if (temp == null) {
                continue;
            }
            if (temp.val == ch) {
                boolean flag = search(temp, searchWord, inx + 1, count);
                if (flag) {
                    return true;
                }
            } else {
                boolean flag = search(temp, searchWord, inx + 1, count + 1);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
}

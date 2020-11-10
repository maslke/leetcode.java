package hard;


import java.util.Deque;
import java.util.LinkedList;

class lc1028 {


    // offical
    public TreeNode recoverFromPreorderOffical(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            }
            else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }


    private int findIndex(String s, String split) {
        int count = split.length();
        char[] chars = s.toCharArray();
        int inx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' && chars[i - 1] != '-') {
                int j;
                for (j = i; j < i + count; j++) {
                    if (chars[j] != '-') {
                        break;
                    }
                }
                if (j == i + count && chars[j] != '-') {
                    inx = i;
                    return inx;
                }
            }
        }
        return inx;
    }

    public TreeNode recoverFromPreorder(String s, String split) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int index = s.indexOf(split);
        if (index == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        int val = Integer.parseInt(s.substring(0, index));
        s = s.substring(index + split.length());
        TreeNode root = new TreeNode(val);
        int inx = findIndex(s, split);
        if (inx == -1) {
            root.left = recoverFromPreorder(s, split + '-');
        } else {
            root.left = recoverFromPreorder(s.substring(0, inx), split + '-');
            root.right = recoverFromPreorder(s.substring(inx + split.length()), split + '-');
        }
        return root;
    }


    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.equals("")) return null;
        int index = S.indexOf("-");
        if (index == -1) {
            return new TreeNode(Integer.valueOf(S));
        }
        int val = Integer.valueOf(S.substring(0, index));
        TreeNode root = new TreeNode(val);
        S = S.substring(index + 1, S.length());
        int inx = 0;
        while (inx < S.length()) {
            if (S.charAt(inx) == '-' && S.charAt(inx + 1) != '-' && S.charAt(inx - 1) != '-') {
                break;
            }
            inx++;
        }
        if (inx == S.length()) {
            root.left = recoverFromPreorder(removeExtraSplit(S));
        } else {
            String s1 = removeExtraSplit(S.substring(0, inx));
            String s2 = removeExtraSplit(S.substring(inx + 1, S.length()));
            root.left = recoverFromPreorder(s1);
            root.right = recoverFromPreorder(s2);
        }
        
        return root;
    }
    
    private String removeExtraSplit(String s) {
        return s.replaceAll("(?<=\\d)--", "-");
    }

    public static void main(String[] args) {
        String s= "1-2--3---4-5--6---7";
        lc1028 instance = new lc1028();
        instance.recoverFromPreorderOffical(s);
    }
}
package hard;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc1028 {
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
        StringBuilder sb = new StringBuilder();
        boolean hasRemoved = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && !hasRemoved) {
                hasRemoved = true;
                continue;
            }
            sb.append(s.charAt(i));
            if (s.charAt(i) != '-') {
                hasRemoved = false;
            }
            
        }
        return sb.toString();
    }
}
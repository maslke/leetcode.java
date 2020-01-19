package medium;

class lc1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return compose(preorder, 0, preorder.length - 1);
    }

    private TreeNode compose(int[] preorder, int begin, int end) {
        if (end < begin) return null;
        TreeNode root = new TreeNode(preorder[begin]);
        int m = -1;
        for (int i = begin + 1; i <= end; i++) {
            if (preorder[i] > root.val) {
                m = i;
                break;
            }
        }

        if (m == -1) {
            root.left = compose(preorder, begin + 1, end);
            root.right = null;
        } else {
            root.left = compose(preorder, begin + 1, m - 1);
            root.right = compose(preorder, m, end);
        }
        
        return root;

    }
}
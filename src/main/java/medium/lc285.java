package medium;

class lc285 {


    private TreeNode result = null;
    private int min = Integer.MAX_VALUE;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        visit(root, p);
        return result;
        
    }

    private void visit(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (root.val > p.val && root.val < min) {
            result = root;
            min = root.val;
        }
        visit(root.right, p);
        visit(root.left, p);
    }

}
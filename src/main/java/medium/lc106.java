package medium;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// 106. Construct Binary Tree from Inorder and Postorder Traversal

class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2) {
        if (begin1 > end1 || begin2 > end2) return null;
        int val = postorder[end2];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = begin1; i <= end1; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = build(inorder, begin1, index - 1, postorder, begin2, begin2 + index - 1 - begin1);
        root.right = build(inorder, index + 1, end1, postorder, begin2 + index - begin1, end2 - 1);
        return root;
    }
}
package medium;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// 105. Construct Binary Tree from Preorder and inorder Traversal

class lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int begin1 = 0;
        int end1 = preorder.length - 1;
        int begin2 = 0;
        int end2 = inorder.length - 1;
        return buildTree(preorder, begin1, end1, inorder, begin2, end2);
    }

    private TreeNode build(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
        if (begin1 > end1 || begin2 > end2) return false;
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = begin2; i <= end2; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        root.left = build(preorder, begin1 + 1, begin1 + index - begin2, inorder, begin2, index - 1);
        root.right = build(preorder, begin1 + index + 1 - begin2, inorder, index + 1, end2);
        return root;
    }
}
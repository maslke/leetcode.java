# Tree
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|Medium|yes|2019-01-08
98|[Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)|Medium|yes|2019-01-07
99|[Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/)|Hard|no
100|[Same Tree](https://leetcode.com/problems/same-tree/)|Easy|yes|2019-01-08
101|[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)|Easy|yes|2019-01-10
102|[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)|Medium|yes|2019-01-08
103|[Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|Medium|yes|2019-01-08
112|[Path Sum](https://leetcode.com/problems/path-sum/)|Easy|yes|2019-01-10
113|[Path Sum II](https://leetcode.com/problems/path-sum-ii/)|Medium|yes|2019-01-16
114|[Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)|Medium|yes|2019-01-16
222|[Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)|Medium|yes|2019-01-04
257|[Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)|Easy|yes|2019-01-12
297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|Hard|yes|2019-01-05
513|[Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)|Medium|yes|2019-01-14
543|[Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)|Easy|yes|2019-01-05
589|[N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)|Easy|yes|2019-01-05
590|[N-ary Tree Postorder Traversal](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)|Easy|yes|2019-01-05
654|[Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/)|Medium|yes|2019-12-30
701|[Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)|Medium|yes|2018-12-29

-------------------------------------------------------------

94. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

中序遍历，使用Set来检测节点是否已经访问过。访问过的节点，直接输出。
也可以使用递归的方式进行处理。

98. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

二叉树的中序遍历，在遍历的时候，保存前一个节点的值。如果节点的值是递增的，则是合法的二叉树

100. [Same Tree](https://leetcode.com/problems/same-tree/)

递归解决。

101. [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

从顶到下，递归解决问题。

```java
 public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }
    
    private boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.val != node2.val) return false;
            return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
        } else if (node1 != null || node2 != null) {
            return false;
        } else {
            return true;
        }
    }
 ```   

102. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

二叉树层次遍历。 二叉树的层次关系可以使用队列来进行存储。

103. [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

二叉树层次遍历。

112. [Path Sum](https://leetcode.com/problems/path-sum/)

使用先序遍历来解决，并使用Map来存储到当前节点的节点值之和。

113. [Path Sum II](https://leetcode.com/problems/path-sum-ii/)

同112.

114. [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

先序遍历。在遍历的时候，依次改变节点的右子树为栈中的下一个节点。

222. [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

计算完全二叉树的节点个数。最容易想到的是暴力的方式，通过层次遍历来进行解决。不过会超时。
对于完全二叉树来说，根节点之下，如果左右子树的高度一样，则左子树一定是完全二叉树。若不一致，则右子树一定是完全二叉树。根据此性质，可以递归的进行解决。

257. [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)

先序遍历问题。

297. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

使用中序遍历来序列化二叉树。在进行反序列化二叉树的时候，使用递归的方式来进行。处理的第一个节点总是中间节点.

513. [Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)

简单的，当然可以通过层次遍历来解决。

相对而言，更优美的方案是，递归的进行二叉树高度的比较。如果左右子树高度相当，则取左子树继续处理。最后处理到的节点，即是结果节点。

```java
public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right  == null) return root.val;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (l >= r) {
            return findBottomLeftValue(root.left);
        } else {
            return findBottomLeftValue(root.right);
        }
    } 
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
```

543. [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

对于特定的某个节点，最大的长度为左子树的高度+右子树的高度。然后进行递归的求解。

589. [N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)

和二叉树的前序遍历求解方式一样。前序遍历的顺序是中间节点、左节点、右节点。

```java
public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ret.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return ret;
    }
```    

590. [N-ary Tree Postorder Traversal](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)

和二叉树的后序求解方式一样。后序遍历的访问顺序是左节点、右节点然后是中间节点。由于中间节点在最后才访问，可以使用Map结构来保存节点是否已访问信息。

使用栈的后进先出特性，来实现访问。

```java
public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (set.contains(node)) {
                ret.add(node.val);
            } else {
                stack.push(node);
                set.add(node);
                List<Node> nodes = node.children;
                for (int i = nodes.size() - 1; i >= 0; i--) {
                    stack.push(nodes.get(i));
                }
                
            }
        }
        return ret;
    }
```    

654. [Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/)

递归处理

701. [Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)

向二叉排序树中新增节点。从当前节点开始，递归的进行处理。如果当前节点为空，则新建节点返回。否则，根据节点值的大小，选择当前节点的左节点或是右节点进行处理。

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.left, val);
                return root;
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.right, val);    
                return root;
            }
        }
    }
```    


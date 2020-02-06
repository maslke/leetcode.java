package medium;

clss lc988 {
    public String smallestFromLeaf(TreeNode root) {
        String ret = null;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, String> map2 = new HashMap<>();
        Map<Integer, Character> map = new HashMap<>();
        for (int i =0; i <= 25; i++) {
            map.put(i, (char)(i + 97));
        }
        map2.put(root, String.valueOf(map.get(root.val)));
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    if (ret == null) {
                        ret = map2.get(node);
                    } else {
                        if (ret.compareTo(map2.get(node)) > 0) {
                            ret = map2.get(node);
                        }
                    }
                }

                if (node.left != null) {
                    map2.put(node.left, String.valueOf(map.get(node.left.val)) + map2.get(node));
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    map2.put(node.right, String.valueOf(map.get(node.right.val)) + map2.get(node));
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }
}
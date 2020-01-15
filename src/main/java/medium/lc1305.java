package medium;

import java.util.List;
import java.util.ArrayList;

class lc1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        visit(root1, list1);
        visit(root2, list2);
        int i = 0;
        int j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size() && j < list2.size()) {
                if (list1.get(i) <= list2.get(j)) {
                    list3.add(list1.get(i));
                    i++;
                } else {
                    list3.add(list2.get(j));
                    j++;
                }
            } else if (i < list1.size()) {
                list3.add(list1.get(i));
                i++;
            } else if (j < list2.size()) {
                list3.add(list2.get(j));
                j++;
            }
        }
        return list3;
    }

    private void visit(TreeNode node, List<Integer> list) {
        if (node == null) return;
        visit(node.left, list);
        list.add(node.val);
        visit(node.right, list);
    }
}
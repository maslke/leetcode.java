package easy;

import java.util.List;

// https://leetcode-cn.com/problems/maximum-distance-in-arrays/
// 624. 数组列表中的最大距离

class lc624 {

    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int maxDistance(List<List<Integer>> arrays) {
        Node min1 = null;
        Node min2 = null;
        Node max1 = null;
        Node max2 = null;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> values = arrays.get(i);
            if (min1 == null) {
                min1 = new Node(values.get(0), i);
            } else {
                if (values.get(0) < min1.val) {
                    min2 = min1;
                    min1 = new Node(values.get(0), i);
                } else {
                    if (min2 == null || values.get(0) < min2.val) {
                        min2 = new Node(values.get(0), i);
                    }
                }
            }

            if (max1 == null) {
                max1 = new Node(values.get(values.size() - 1), i);
            } else {
                if (values.get(values.size() - 1) > max1.val) {
                    max2 = max1;
                    max1 = new Node(values.get(values.size() - 1), i);
                } else {
                    if (max2 == null || values.get(values.size() - 1) > max2.val) {
                        max2 = new Node(values.get(values.size() - 1), i);
                    }
                }
            }
        }

        if (min1.index != max1.index) {
            return max1.val - min1.val;
        } else {
            return Math.max(max2.val - min1.val, max1.val - min2.val);

        }
    }
}


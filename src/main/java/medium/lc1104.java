package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
// 1104. 二叉树寻路

class lc1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        result.add(0, label);
        while (label > 1) {
            result.add(0, label / 2);
            label = label / 2;
        }
        int level = result.size();
        if (level <= 2) return result;
        boolean reverse = true;
        for (int i = level - 2; i >= 1; i--) {
            if (reverse) {
                result.set(i, convert(result.get(i), i + 1));
            }
            reverse = !reverse;
        }
        return result;
    } 

    private int convert(int m, int level) {
        int a = level - 1;
        int min = (int)(Math.pow(2, a));
        int max = (int)(Math.pow(2, level)) - 1;
        return min + max - m;
    }

    // better ,simple
    public List<Integer> pathInZigZagTree2(int label) {
        int level = 0;
        while (Math.pow(2, level + 1) <= label) {
            level++;
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(label);
        while (level > 0) {
            label = label / 2;
            int sum = sum(level - 1);
            label = sum - label;
            list.addFirst(label);
            level--;
        }
        return list;

    }

    private int sum(int level) {
        int min = (int)(Math.pow(2, level));
        int max = (int) (Math.pow(2, level + 1)) - 1;
        return (min + max);
    }
}
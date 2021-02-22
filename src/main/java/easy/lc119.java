package easy;

import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/pascals-triangle-ii/
// 119. 杨辉三角 II
public class lc119 {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> list = new LinkedList<>();

        list.offerLast(1);
        if (rowIndex == 0) {
            return list;
        }
        list.offerLast(1);
        if (rowIndex == 1) {
            return list;
        }

        for (int i = 2; i <= rowIndex; i++) {

            for (int j = 0; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            list.offerFirst(1);
        }
        return list;
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 */
public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return ret;
        }
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        ret.add(list1);
        if (numRows == 1) {
            return ret;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i + 1);
            list.add(1);
            List<Integer> temp = ret.get(i - 1);
            for (int j = 0; j < temp.size() - 1; j++) {
                list.add(temp.get(j) + temp.get(j + 1));
            }
            list.add(1);
            ret.add(list);
        }
        return ret;
    }
}

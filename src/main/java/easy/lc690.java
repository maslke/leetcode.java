package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/29
 * Version:0.0.1
 * 690. Employee Importance
 */
public class lc690 {
    class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        if (!map.containsKey(id)) {
            return 0;
        }
        Map<Integer, Integer> saved = new HashMap<Integer, Integer>();
        saved.put(id, 1);
        return importance(map, saved, id) + map.get(id).importance;
    }
    private int importance(Map<Integer, Employee> map, Map<Integer, Integer> saved, int id) {
        Employee e = map.get(id);
        int ret = 0;
        List<Integer> sub = e.subordinates;
        for (Integer v : sub) {
            if (!saved.containsKey(v)) {
                saved.put(v, 1);
                ret += map.get(v).importance + importance(map, saved, v);
            }

        }
        return ret;
    }
}

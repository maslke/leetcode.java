package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// https://leetcode-cn.com/problems/destination-city/

public class lc1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }

        String begin = paths.get(0).get(0);
        while (true) {
            String end = map.get(begin);
            if (end == null) {
                break;
            }
            begin = end;
        }
        return begin;
    }
}

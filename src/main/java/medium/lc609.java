package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/find-duplicate-file-in-system/
// 609. 在系统中查找重复文件

public class lc609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];
            for (int i = 1; i < parts.length; i++) {
                int index = parts[i].indexOf('(');
                String name = parts[i].substring(0, index);
                String content = parts[i].substring(index + 1, parts[i].length() - 1);
                String fullName = directory + '/' + name;
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(fullName);
                map.put(content, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }
}

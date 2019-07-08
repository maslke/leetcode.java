package easy;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

//https://leetcode.com/problems/subdomain-visit-count/
//811. Subdomain Visit Count
class lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] words = cpdomains[i].split(" ");
            String times = words[0];
            String[] sites = words[1].split("\\.");
            for (int j = 0; j < sites.length; j++) {
                String temp = sites[j];
                for (int m = j + 1; m < sites.length; m++) {
                    temp = temp + "." + sites[m];
                }
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + Integer.valueOf(times));
                } else {
                    map.put(temp, Integer.valueOf(times));
                }
            }
        }
        List<String> ret = new ArrayList<String>();
        for (String key : map.keySet()) {
            ret.add(map.get(key) + " " + key);
        }
        return ret;
    }
}
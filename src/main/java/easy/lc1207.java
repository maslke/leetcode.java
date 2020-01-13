package easy;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap:

class lc1207 {
  public boolean uniqueOccurrences(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < arr.length; i++) {
          if (map.containsKey(arr[i])) {
              map.put(arr[i], map.get(arr[i]) + 1);
           } else {
               map.put(arr[i], 1);
           }
      }
  }  
  Set<Integer> set = new HashSet<>(map.values());
  return map.values.size() == set.size();
}
package easy;

import java.util.HashMap;
import java.util.Map;

class lc1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length - i - 1; j++) {
                if (!less(arr1[j], arr1[j + 1], map)) {
                    swap(arr1, j, j + 1);
                }
            }
        }
        return arr1;
        
    }
    
    private boolean less(int a, int b, Map<Integer, Integer> map) {
        if (map.containsKey(a) && map.containsKey(b)) {
            return map.get(a) < map.get(b);
        } else if (map.containsKey(b)) {
            return false;
        } else if (map.containsKey(a)) {
            return true;
        } 
        return a < b;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
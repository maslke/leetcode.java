package medium;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/product-of-the-last-k-numbers/
// 1352. Product of the Last K Numbers

class lc1352 {
    
    private Map<Integer, Integer> map;
    private int count;

    public ProductOfNumbers() {
        map = new HashMap<>();
        count = 0;
        map.put(0, 1);
    }
    
    public void add(int num) {
        if (num == 0) {
            map.clear();
            count = 0;
            map.put(0, 1);
        } else {
            count++;
            map.put(count, map.get(count - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k > count) return 0;
        if (k == count) return map.get(k);
        return map.get(count) / map.get(count - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
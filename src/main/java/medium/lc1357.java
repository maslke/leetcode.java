package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/apply-discount-every-n-orders/
// 1357. Apply Discount Every n Orders
class Cashier {
    
    private int count;
    private int current;
    private Map<Integer, Integer> map;
    private int discount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.count = n;
        this.current = 0;
        this.discount = discount;
        this.map = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        int value = 0;
        for (int i = 0; i < product.length; i++) {
            value += map.get(product[i]) * amount[i];
        }
        this.current++;
        if (this.current == this.count) {
            this.current = 0;
            return 1.0 * value * (1.0 - 1.0 * this.discount / 100);
        } else {
            return 1.0 * value;
        }
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
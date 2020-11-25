package medium;

// https://leetcode.com/problems/largest-number/
// 179. Largest Number

class lc179 {
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length];
        if (values.length == 0) return "";
        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }
        sort(values, 0, values.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            sb.append(values[i]);
        }
    
        String ret = sb.toString();
        if (ret.charAt(0) == '0') return "0";
        return ret;
    }
    
    private boolean less(String a, String b) {
        return (a + b).compareTo(b + a) < 0;
    }
    
    private void swap(String[] values, int i, int j) {
        String temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
    
    private void sort(String[] values, int low, int high) {
        if (low >= high) return;
        int p = partition(values, low, high);
        sort(values, low, p - 1);
        sort(values, p + 1, high);
    }
    
    private int partition(String[] values, int low, int high) {
        String m = values[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(values[++i], m)) {
                if (i == high) break;
            }
            while (less(m, values[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(values, i, j);
        }
        swap(values, low, j);
        return j;
    }
}
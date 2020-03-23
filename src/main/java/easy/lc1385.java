package easy;

// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// 1385. Find the Distance Value Between Two Arrays

class lc1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
                if (!lessThan(arr2, 0, arr2.length - 1, arr1[i], d)) {
                    count++;
                }
        }
        
        return count;
    }
    
    private boolean lessThan(int[] values, int left, int right, int current, int d) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = values[middle];
            if (Math.abs(value - current) <= d) return true;
            if (value - current > d) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } 
        return false;
    }
}
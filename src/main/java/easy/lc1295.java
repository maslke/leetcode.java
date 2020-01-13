package easy;

class lc1295 {
    public int findNumbers(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isEven(nums[i])) {
                sum++;
            }
        }
        return sum;
    }

    // a >= 1 && a <= 100000
    private boolean isEven(int a) {
        return (a >= 10 && a <= 99) || (a >= 1000 && a <= 9999) || (a == 100000);
    }
}
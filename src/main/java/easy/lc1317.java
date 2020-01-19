class lc1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] ret = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            if (!containsZero(i) && !containsZero(j)) {
                ret[0] = i;
                ret[1] = j;
            }
        }
        return ret;
    }
    
    private boolean containsZero(int m) {
        while (m > 0) {
            if (m % 10 == 0) return true;
            m = m / 10;
        }
        return false;
    }
}
package easy;

public class lc1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int length = arr.length;
        if (length < 3) {
            return false;
        }
        int i = 0;
        int count = 0;
        while (i < length) {
            if (arr[i] % 2 == 0) {
                i = i + 1;
                count = 0;
            }
            else {
                count++;
                if (count == 3) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}

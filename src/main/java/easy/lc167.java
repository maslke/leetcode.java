package easy;

/**
 * Author:maslke
 * Date:2017/8/22
 * Version:0.0.1
 * 167. Two Sum II - Input array is sorted
 */
public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int i = 0, j = numbers.length - 1;
        boolean success = false;
        while (i < j) {
            int val = target - numbers[i];
            if (val > numbers[j]) {
                i++;
            } else if (val < numbers[j]) {
                j--;
            } else {
                ret[0] = i + 1;
                ret[1] = j + 1;
                break;
            }
        }
        return ret;
    }
}

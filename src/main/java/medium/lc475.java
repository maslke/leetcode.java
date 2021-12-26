package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/heaters/
// 475. 供暖器
public class lc475 {
    public int findRadius(int[] houses, int[] heaters) {
        int ret = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int inx = bs(heaters, house);
            int distance;
            if (inx == -1) {
                distance = house - heaters[heaters.length - 1];
            }
            else if (inx == 0) {
                distance = heaters[0] - house;
            }
            else {
                distance = Math.min(heaters[inx] - house, house - heaters[inx - 1]);
            }
            ret = Math.max(ret, distance);
        }
        return ret;
    }

    // find first > house
    private int bs(int[] heaters, int house) {
        int left = 0;
        int right = heaters.length - 1;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] > house) {
                ret = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ret;
    }
}

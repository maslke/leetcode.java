package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 */
public class lc278 {
    private int badVersion;
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        badVersion = -1;
        return bad(1 , n);
    }

    //TODO
    private boolean isBadVersion(int n) {
        //return true or false
        return true;
    }

    private int bad(int left, int right) {
        if (left >= right) {
            if (isBadVersion(left)) {
                return left;
            } else {
                return badVersion;
            }
        }
        int mid = left + (right - left) / 2;
        boolean flag = isBadVersion(mid);
        if (flag) {
            badVersion = mid;
            return bad(left, mid - 1);
        } else {
            return bad(mid + 1, right);
        }
    }
}

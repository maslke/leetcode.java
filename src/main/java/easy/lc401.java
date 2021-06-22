package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/binary-watch/
// 401. 二进制手表
public class lc401 {
    List<String> ret;

    public List<String> readBinaryWatch(int turnedOn) {
        ret = new ArrayList<>();
        backtrace(turnedOn, 0, 0, 0);
        return ret;
    }

    private void backtrace(int all, int on, int target, int value) {
        if (target > 10) {
            return;
        }
        if (on == all) {

            int minutes = value & 63;
            if (minutes >= 60) {
                return;
            }
            int hours = (value >> 6) & 15;

            if (hours >= 12) {
                return;
            }
            if (minutes < 10) {
                ret.add(hours + ":0" + minutes);
            }
            else {
                ret.add(hours + ":" + minutes);
            }
            return;
        }

        backtrace(all, on + 1, target + 1, (value | (1 << target)));
        backtrace(all, on, target + 1, value);
    }
}

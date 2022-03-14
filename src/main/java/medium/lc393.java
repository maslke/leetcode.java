package medium;

// https://leetcode-cn.com/problems/utf-8-validation/
// 393. UTF-8 编码验证
public class lc393 {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int inx = 0;
        while (inx < len) {
            int current = data[inx];
            if ((current & 128) == 0) {
                inx++;
                continue;
            }
            int count = 0;
            if ((current & 240) == 240) {
                count = 4;
            }
            else if ((current & 224) == 224) {
                count = 3;
            }
            else if ((current & 192) == 192) {
                count = 2;
            }

            if (((current >> (7 - count)) & 1) != 0) {
                return false;
            }

            for (int i = inx + 1; i < inx + count; i++) {
                if (i >= len) {
                    return false;
                }
                if ((data[i] & 192) != 128) {
                    return false;
                }
            }

            inx = inx + count;
        }
        return true;
    }
}

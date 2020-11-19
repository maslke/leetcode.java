package easy;

// https://leetcode-cn.com/problems/defuse-the-bomb/
// 1652. 拆炸弹
public class lc1652 {

    public int[] decrypt2(int[] code, int k) {
        int length = code.length;
        int[] ret = new int[length];
        if (k == 0) {
            return ret;
        }

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = 0; j < Math.abs(k); j++) {
                if (k > 0) {
                    sum += code[(i + j + 1 + length) % length];
                } else {
                    sum += code[(length + i - j - 1) % length];
                }
            }
            ret[i] = sum;
        }

        return ret;
    }

    // faster
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] ret = new int[length];
        if (k == 0) {
            return ret;
        }
        if (k > 0) {
            int begin = 0;
            int inx = 0;
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    int count = 0;
                    inx = i + 1;
                    while (count < k) {
                        begin += code[inx];
                        if (inx == length - 1) {
                            inx = 0;
                        }
                        else {
                            inx++;
                        }
                        count++;
                    }
                    ret[i] = begin;
                }
                else {
                    begin -= code[i];
                    begin += code[inx];
                    if (inx == length - 1) {
                        inx = 0;
                    }
                    else {
                        inx++;
                    }
                    ret[i] = begin;
                }
            }
        }
        else {
            revert(code);
            int[] r = decrypt(code, Math.abs(k));
            revert(r);
            ret = r;
        }

        return ret;
    }

    private void revert(int[] code) {
        int i = 0;
        int j = code.length - 1;
        while (i < j) {
            int temp = code[i];
            code[i] = code[j];
            code[j] = temp;
            i++;
            j--;
        }
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;

public class lc784 {
    List<String> ret = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        permutations(chars, 0, chars.length);
        return ret;
    }

    private void permutations(char[] chars, int i, int len) {
        if (i == len) {
            ret.add(new String(chars));
            return;
        }
        char c = chars[i];
        if (c >= '0' && c <= '9') {
            permutations(chars, i + 1, len);
        }
        else {
            if (c >= 'a' && c <= 'z') {
                chars[i] -= 32;
            }
            else {
                chars[i] += 32;
            }
            permutations(chars, i + 1, len);
            chars[i] = c;
            permutations(chars, i + 1, len);
        }
    }
}

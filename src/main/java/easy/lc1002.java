package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-common-characters/
 * 1002. Find Common Characters
 */
class lc1002 {
    List<String> commonChars(String[] A) {
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            inputs.add(A[i]);
        }        

        List<String> ret = common(inputs);
        if (ret.size() == 0) return Collections.emptyList();
        String r = ret.get(0);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < r.length(); i++) {
            result.add(new String(new char[]{r.charAt(i)}));
        }
        return result;
    }

    private List<String> common(List<String> ret) {
        if (ret.size() == 0) return Collections.emptyList();
        if (ret.size() == 1) return ret;
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < ret.size()) {
            if (i + 1 < ret.size()) {
                result.add(common(ret.get(i), ret.get(i + 1)));
            } else {
                result.add(ret.get(i));
            }
            i = i + 2;
        }
        return result;
    }

    private String common(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        int i = 0;
        int j = 0;
        List<Character> ret = new ArrayList<>();
        while (i < a.length() && j < a.length()) {
            if (ca[i] == cb[j]) {
                ret.add(ca[i]);
                i++;
                j++;
            } else if (ca[i] < cb[j]) {
                i++;
            } else {
                j++;
            }
        }
        char[] chars = new char[ret.size()];
        for (int m = 0; m < ret.size(); m++) {
            chars[m] = ret.get(m);
        }
        return new String(chars);
    }
}
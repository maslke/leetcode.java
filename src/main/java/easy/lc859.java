package easy;

import java.util.Map;
import java.util.HashMap;

//https://leetcode.com/problems/buddy-strings/
//859. Buddy Strings
class lc895 {
    public boolean buddyStrings(String A, String B) {
        int count = 0;
        int len1 = A.length();
        int len2 = B.length();
        if (len1 != len2)
            return false;
        int i = 0;
        int j = 0;
        char[] chars = new char[2];
        while (i < len1 && j < len2) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                if (count == 0) {
                    count++;
                    chars[0] = A.charAt(i);
                    chars[1] = B.charAt(j);
                } else if (count == 1) {
                    if (!(chars[0] == B.charAt(j) && chars[1] == A.charAt(i))) {
                        return false;
                    }
                    count++;

                } else {
                    count++;
                    break;
                }
                i++;
                j++;
            }
        }
        if (count == 0) {
            Map<Character, Integer> map = new HashMap<>();
            for (i = 0; i < len1; i++) {
                if (map.containsKey(A.charAt(i))) {
                    return true;
                } else {
                    map.put(A.charAt(i), 1);
                }
            }
            return false;
        } else {
            return count == 2;
        }
    }
}
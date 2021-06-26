package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
// 17. 电话号码的字母组合

class lc17 {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.equals("")) return ret;
        Map<Character, String> map = new HashMap<>();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 2; i <= 6; i++) {
            map.put((char) (48 + i), letters.substring(3 * i - 6, 3 * i - 3));
        }
        map.put((char) (48 + 7), "pqrs");
        map.put((char) (48 + 8), "tuv");
        map.put((char) (48 + 9), "wxyz");

        String first = map.get(digits.charAt(0));
        for (int i = 0; i < first.length(); i++) {
            ret.add(first.substring(i, i + 1));
        }

        for (int i = 1; i < digits.length(); i++) {
            String w = map.get(digits.charAt(i));
            List<String> result = new ArrayList<>();
            for (int j = 0; j < w.length(); j++) {
                for (int m = 0; m < ret.size(); m++) {
                    result.add(ret.get(m) + w.substring(j, j + 1));
                }
            }
            ret = result;
        }

        return ret;
    }

    public List<String> letterCombinations2(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> ret = new ArrayList<>();
        backtrace(digits, 0, new StringBuilder(), map, ret);
        return ret;
    }

    private void backtrace(String digits, int position, StringBuilder sb, Map<String, String> map, List<String> ret) {
        if (position >= digits.length()) {
            if (digits.length() > 0) {
                ret.add(sb.toString());
            }
            return;
        }
        String d = map.get(digits.substring(position, position + 1));
        for (int i = 0; i < d.length(); i++) {
            sb.append(d.charAt(i));
            backtrace(digits, position + 1, sb, map, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        lc17 instance = new lc17();
        List<String> ret = instance.letterCombinations2("23");
        ret = instance.letterCombinations2("246");
    }
}
package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc273 {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        String value = String.valueOf(num);
        int len = value.length();
        if (len % 3 == 1) {
            value = "00" + value;
            len = len + 2;
        }
        else if (len % 3 == 2) {
            value = "0" + value;
            len = len + 1;
        }
        Stack<String> stack = new Stack<>();

        Map<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");
        map.put("6", "Six");
        map.put("7", "Seven");
        map.put("8", "Eight");
        map.put("9", "Nine");
        map.put("10", "Ten");
        map.put("11", "Eleven");
        map.put("12", "Twelve");
        map.put("13", "Thirteen");
        map.put("14", "Fourteen");
        map.put("15", "Fifteen");
        map.put("16", "Sixteen");
        map.put("17", "Seventeen");
        map.put("18", "Eighteen");
        map.put("19", "Nineteen");
        map.put("20", "Twenty");
        map.put("30", "Thirty");
        map.put("40", "Forty");
        map.put("50", "Fifty");
        map.put("60", "Sixty");
        map.put("70", "Seventy");
        map.put("80", "Eighty");
        map.put("90", "Ninety");

        String[] parts = {"Thousand", "Million", "Billion"};
        int inx = -1;

        while (true) {
            int start = len - 3;
            String str = value.substring(start, len);
            StringBuilder sb2 = new StringBuilder();
            if (!str.equals("000")) {
                if (map.containsKey(str.substring(0, 1))) {
                    sb2.append(" ").append(map.get(str.substring(0, 1))).append(" Hundred");
                }
                if (str.charAt(1) == '1' && str.charAt(2) != '0') {
                    sb2.append(" ").append(map.get(str.substring(1, 3)));
                }
                else {
                    if (map.containsKey(str.charAt(1) + "0")) {
                        sb2.append(" ").append(map.get(str.charAt(1) + "0"));
                    }
                    if (map.containsKey(str.substring(2, 3))) {
                        sb2.append(" ").append(map.get(str.substring(2, 3)));
                    }
                }


                if (inx != -1) {
                    sb2.append(" ").append(parts[inx]);
                }
            }
            if (sb2.length() > 0) {
                stack.push(sb2.toString());
            }
            inx++;
            if (start == 0) {
                break;
            }
            len = start;
        }


        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.substring(1);
    }
}

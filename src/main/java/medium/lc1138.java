package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class lc1138 {
    public String alphabetBoardPath(String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 97);
            List<Integer> list = new ArrayList<>();
            list.add(i / 5);
            list.add(i % 5);
            map.put(c, list);
        }
        StringBuilder sb = new StringBuilder();
        int row = 0;
        int col = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            List<Integer> list = map.get(c);
            int a = list.get(0);
            int b = list.get(1);
            int a1 = a;
            if (col != 0 && a == 5) {
                a1 = a - 1;
            }
            String step = a > row ? "D" : "U";
            for (int j = 0; j < Math.abs(a1 - row); j++) {
                sb.append(step);
            }
            step = b > col ? "R" : "L";
            for (int j = 0; j < Math.abs(b - col); j++) {
                sb.append(step);
            }
            if (a1 == a - 1) {
                sb.append("D");
            }
            sb.append("!");
            row = a;
            col = b;
        }
        return sb.toString();
    }
}
package easy;

import java.util.Map;
import java.util.HashMap;

class lc1309 {
    public String freqAlphabets(String s) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i <= 26; i++) {
            map.put(String.valueOf(i), String.valueOf((char)(96 + i)));
        }

        StringBuilder sb = new StringBuilder();
        String[] contents = s.split("#");
        for (int i = 0; i < contents.length; i++) {
            String c = contents[i];
            if (!s.endsWith("#") && i == contents.length - 1) {
                for (int j = 0; j < c.length(); j++) {
                    sb.append(map.get(c.substring(j, j + 1)));
                }
            } else {
                if (c.length() <= 2) {
                    sb.append(map.get(c));
                } else {
                    while (c.length() > 2) {
                        String m = c.substring(0, 1);
                        sb.append(map.get(m));
                        c = c.substring(1, c.length());
                    }
                    sb.append(map.get(c));
                }
            }
        }
        return sb.toString();
    }


    public String freqAlphabets2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (i + 2 > j || chars[i + 2] != '#') {
                sb.append((char)(Integer.parseInt(String.valueOf(chars[i])) + 96));
                i++;
            } else {
                sb.append((char)(Integer.parseInt(s.substring(i, i + 2)) + 96));
                i = i + 3;
            }
        }
        return sb.toString();
    }
}

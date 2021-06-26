package hard;

import java.util.*;

// https://leetcode-cn.com/problems/sliding-puzzle/
// 773. 滑动谜题

public class lc773 {
    public int slidingPuzzle(int[][] board) {
        int[][] mapper = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {2, 4}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        String end = "123450";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> set = new HashSet<>();
        set.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String value = queue.poll();
                if (value.equals(end)) {
                    return step - 1;
                }
                for (String v : next(value, mapper)) {
                    if (!set.contains(v)) {
                        set.add(v);
                        queue.offer(v);
                    }
                }
            }
        }

        return -1;

    }

    private List<String> next(String str, int[][] mapper) {
        List<String> list = new ArrayList<>();

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {

                for (int j = 0; j < mapper[i].length; j++) {
                    list.add(getValue(str, i, mapper[i][j]));
                }

                break;

            }
        }

        return list;
    }

    private String getValue(String str, int i, int j) {
        char[] chars = str.toCharArray();
        chars[i] = chars[j];
        chars[j] = '0';
        return new String(chars);
    }
}

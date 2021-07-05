package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/number-of-atoms/
// 726. 原子的数量

public class lc726 {
    static class Node {
        String key;
        int value;

        Node(String key) {
            this.key = key;
            this.value = 1;
        }

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public String countOfAtoms(String formula) {
        Deque<Node> deque = new ArrayDeque<>();
        int length = formula.length();
        int i = 0;
        while (i < length) {
            char c = formula.charAt(i);
            if (c == '(') {
                i++;
                deque.offerLast(new Node("("));
            }
            else if (c == ')') {
                i++;
                continue;
            }
            else if (isNumeric(c)) {
                int j = i;
                while (j < length && isNumeric(formula.charAt(j))) {
                    j++;
                }

                int times = Integer.parseInt(formula.substring(i, j));

                char prev = formula.charAt(i - 1);
                if (prev == ')') {
                    List<Node> nodes = new ArrayList<>();
                    while (!deque.peekLast().key.equals("(")) {
                        nodes.add(deque.pollLast());
                    }
                    deque.pollLast();
                    for (int inx = nodes.size() - 1; inx >= 0; inx--) {
                        nodes.get(inx).value = nodes.get(inx).value * times;
                        deque.offerLast(nodes.get(inx));
                    }
                }
                else {
                    Node node = deque.pollLast();
                    node.value = node.value * times;
                    deque.offerLast(node);
                }
                i = j;
            }
            else {
                int j = i + 1;
                while (j < length && isAlpha(formula.charAt(j))) {
                    j++;
                }
                String s = formula.substring(i, j);
                i = j;
                deque.offerLast(new Node(s));
            }
        }


        Map<String, Integer> map = new HashMap<>();
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            if (node.key.equals("(")) {
                continue;
            }
            map.put(node.key, map.getOrDefault(node.key, 0) + node.value);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> a.compareTo(b));

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            if (map.get(key) != 1) {
                sb.append(map.get(key));
            }
        }
        return sb.toString();

    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z');
    }
}

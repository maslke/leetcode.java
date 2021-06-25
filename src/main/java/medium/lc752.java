package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode-cn.com/problems/open-the-lock/
// 752. 打开转盘锁

public class lc752 {

    public int openLock(String[] deadends, String target) {
        Set<Integer> dead = new HashSet<>();
        for (String end : deadends) {
            dead.add(Integer.parseInt(end));
        }
        if (dead.contains(0)) {
            return -1;
        }
        int tar = Integer.parseInt(target);
        if (tar == 0) {
            return 0;
        }

        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int v : getNext(node)) {
                    if (!visited[v] && !dead.contains(v)) {
                        if (v == tar) {
                            return step;
                        }
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
        return -1;


    }

    private List<Integer> getNext(int node) {
        int i = node / 1000 % 10;
        int j = node / 100 % 10;
        int k = node / 10 % 10;
        int l = node % 10;

        List<Integer> list = new ArrayList<>();

        list.add(1000 * i + 100 * j + k * 10 + (l + 1) % 10);
        list.add(1000 * i + 100 * j + (k + 1) % 10 * 10 + l);
        list.add(1000 * i + (j + 1) % 10 * 100 + 10 * k + l);
        list.add((i + 1) % 10 * 1000 + 100 * j + 10 * k + l);


        list.add(1000 * i + 100 * j + k * 10 + (l == 0 ? 9 : (l - 1)));
        list.add(1000 * i + 100 * j + (k == 0 ? 9 : (k - 1)) * 10 + l);
        list.add(1000 * i + (j == 0 ? 9 : (j - 1)) * 100 + 10 * k + l);
        list.add((i == 0 ? 9 : i - 1) * 1000 + j * 100 + k * 10 + l);
        return list;
    }
}

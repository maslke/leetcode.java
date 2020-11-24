package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

// https://leetcode-cn.com/problems/get-watched-videos-by-your-friends/
// 1311. 获取你好友已观看的视频

public class lc1311 {

    class Pair {
        int count;
        String name;

        Pair(int count, String name) {
            this.count = count;
            this.name = name;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> list = new LinkedList<>();
        list.offer(id);
        Set<Integer> set2 = new HashSet<>();
        set2.add(id);
        while (level > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] people = friends[list.poll()];
                for (int p : people) {
                    if (!set2.contains(p)) {
                        list.offer(p);
                        set2.add(p);
                    }
                }
            }
            level--;
        }
        Map<String, Integer> map = new TreeMap<>();
        for (Integer val : list) {
            List<String> movies = watchedVideos.get(val);
            for (String m : movies) {
                map.put(m, map.getOrDefault(m, 0) + 1);
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pairs.add(new Pair(entry.getValue(), entry.getKey()));
        }

        pairs.sort((a, b) -> {
            if (a.count == b.count) {
                return a.name.compareTo(b.name);
            }
            return a.count - b.count;
        });
        return pairs.stream().map(r -> r.name).collect(Collectors.toList());
    }
}

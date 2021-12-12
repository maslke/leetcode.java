package medium;

import java.util.TreeMap;

// https://leetcode-cn.com/problems/online-election/
// 911. 在线选举
public class lc911 {
    private int[] votes;
    private int[] times;
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public lc911(int[] persons, int[] times) {
        this.votes = new int[persons.length];
        this.times = times;
        int successor = persons[0];
        int max = 1;
        map.put(times[0], successor);
        this.votes[persons[0]]++;
        for (int i = 1; i < persons.length; i++) {
            int num = ++this.votes[persons[i]];
            if (num >= max) {
                map.put(times[i], persons[i]);
                successor = persons[i];
                max = num;
            } else {
                map.put(times[i], successor);
            }
        }
    }

    public int q(int t) {
        // 查找第一个 大于t的时间节点
        int left = 0;
        int right = times.length - 1;
        int inx = times.length;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (times[middle] > t) {
                inx = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return map.get(times[inx - 1]);
    }
}

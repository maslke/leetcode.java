package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/task-scheduler/
// 621. 任务调度器

public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] chars = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            chars[tasks[i] - 'A']++;
        }
        Arrays.sort(chars);
        int max = 0;
        int times = chars[25];
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (chars[i] == chars[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }

        max = (n + 1) * (times - 1) + maxCount;

        return Math.max(max, tasks.length);
    }
}

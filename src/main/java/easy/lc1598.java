package easy;

// https://leetcode-cn.com/problems/crawler-log-folder/
// 1598. 文件夹操作日志收集器

public class lc1598 {
    public int minOperations(String[] logs) {
        int size = 0;
        for (String log : logs) {
            if (log.startsWith("..")) {
                if (size > 0) {
                    size--;
                }
            } else if (!log.startsWith(".")) {
                size++;
            }
        }
        return size;
    }
}

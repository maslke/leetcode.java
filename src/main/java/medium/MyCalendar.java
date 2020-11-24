package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/my-calendar-i/
// 729. 我的日程安排表 I

public class MyCalendar {

    private List<int[]> calenders;

    public MyCalendar() {
        this.calenders = new ArrayList<>(100);
    }

    public boolean book(int start, int end) {
        for (int[] c : calenders) {
            if (!(start >= c[1] || end <= c[0])) {
                return false;
            }
        }
        calenders.add(new int[] {start, end});
        return true;
    }
}

class MyCalendar2 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar2() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}


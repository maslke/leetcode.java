package easy;

/***
 * https://leetcode.com/problems/number-of-recent-calls/
 * 933. Number of Recent Calls
 */
import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {
    
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
        
    }
    
    public int ping(int t) {
        while (!queue.isEmpty()) {
            if (t - queue.peek() <= 3000) {
                break;
            } else {
                queue.poll();
            }
        }
        queue.add(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
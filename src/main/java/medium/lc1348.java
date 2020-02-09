package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/tweet-counts-per-frequency/
// 1348. Tweet Counts Per Frequency

class TweetCounts {
    
    private Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if (map.containsKey(tweetName)) {
            map.get(tweetName).add(time);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(time);
            map.put(tweetName, list);
        }
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        if (!map.containsKey(tweetName)) return result;
        int delta = 0;
        if ("minute".equals(freq)) {
            delta = 60;
        } else if ("hour".equals(freq)) {
            delta = 3600;
        } else {
            delta = 3600 * 24;
        }
        
        List<Integer> tweets = map.get(tweetName);
        int index = 1;
        int a = startTime;
        int b = 0;
        while (true) {
            b = startTime + delta * index;
            boolean exit = false;
            if (b >= endTime + 1) {
                b = endTime + 1;
                exit = true;
            }
            int count = 0;
            for (Integer tweet : tweets) {
                if (tweet >= a && tweet < b) {
                    count++;
                }
            }
            result.add(count);            
            if (exit) {
                break;
            } else {
                a = b;
                index = index + 1;
            }
        }
        
        return result;    
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
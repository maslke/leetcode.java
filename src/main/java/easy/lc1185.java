package easy;

// https://leetcode.com/problems/day-of-the-week/
// 1185. Day of the Week

class Solution {
    // 1971/1/1 Friday
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[] {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};    
        int[] months = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        
        int diff = (year - 1971) * 365 + day + months[month - 1] - 1;
        if (month > 2 && isLeap(year)) diff++;
        for (int i = 1971; i < year; i++) {
            if (isLeap(i)) {
                diff++;
            }
        }
        
        return days[diff % 7];
       
    }
    
    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
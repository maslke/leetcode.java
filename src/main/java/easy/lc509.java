//https://leetcode.com/problems/fibonacci-number/
//509. Fibonacci Number
class Solution {
    public int fib(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= N; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
        return map.get(N);
    }
}
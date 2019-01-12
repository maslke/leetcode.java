# String
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
696|[Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)|Easy|yes|2019-01-11


696. [Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)

对于给定的字符串，可以形成 m * 1 + n * 0 + m1 * 1 + n1 * n这种形式。
对于相邻的两组数字，只要比较m和n的最小值，即是最终可以形成的字符串的个数.

```java
public int countBinarySubstrings(String s) {
        List<Integer> values = new ArrayList<>();
        int i = 0;
        int j = s.length();
        while (i < j) {
            char c = s.charAt(i);
            int m = i + 1;
            while (m < j) {
                if (s.charAt(m) == c) {
                    m++;
                } else {
                    break;
                }
            }
            values.add(m - i);
            i = m;
        }
        int ret = 0;
        int size = values.size();
        for (i = 0; i < size - 1; i++) {
            ret += Math.min(values.get(i), values.get(i + 1));
        }
        return ret;
    }
```    

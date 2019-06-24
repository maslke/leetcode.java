# String
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|Easy|yes|2019-01-08
680|[Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)|Easy|yes|2019-1-14
686|[Repeated String Match](https://leetcode.com/problems/repeated-string-match/)|Easy|yes|2019-1-14
696|[Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)|Easy|yes|2019-01-11
848|[Shifting Letters](https://leetcode.com/problems/shifting-letters/)|Medium|yes|2019-01-12
859|[Buddy Strings](https://leetcode.com/problems/buddy-strings/)|Easy|yes|2019-01-09

----

58. [Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

一次遍历即可。

680. [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

对于给定字符串，在判定某个位置不相等的情况下，分为两种情况进行处理。

```java
public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int inx1 = 0;
        int inx2 = 0;
        int count = 0;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (count == 0) {
                    count++;
                    inx1 = i;
                    inx2 = j;
                    i++;
                } else if (count == 1) {
                    count++;
                    i = inx1;
                    j = inx2 - 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
```

686. [Repeated String Match](https://leetcode.com/problems/repeated-string-match/)

字符串问题。计算字符串A叠加多少次之后，可以包含字符串B。注意退出条件即可。

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

848. [Shifting Letters](https://leetcode.com/problems/shifting-letters/)

问题很简单，需要注意的是问题规模的化简。

859. [Buddy Strings](https://leetcode.com/problems/buddy-strings/)

判断两个字符串长度相等并且只有一个字符存在着交换。当两个字符串相等的时候，需要判断字符串中是否存在着重复的字符。即在字符串相等的时候，可以交换一个重复的字符。



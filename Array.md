# Array(4/154)
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1|[Two Sum](https://leetcode.com/problems/two-sum/)|Easy|yes|2018-12-28
15|[3Sum](https://leetcode.com/problems/3sum/)|Medium|yes|2019-01-07
26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|Easy|yes|2019-01-10
27|[Remove Element](https://leetcode.com/problems/remove-element/)|Easy|yes|2019-01-10
153|[Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)|Medium|yes|2019-01-19
289|[Game Of Life](https://leetcode.com/problems/game-of-life/)|Medium|yes|2020-01-11
791|[Custom Sort String](https://leetcode.com/problems/custom-sort-string/)|Medium|yes|2020-01-07
----------------------------------------------------------------
1. [Two Sum](https://leetcode.com/problems/two-sum/)

题目设定了一定会有符合要求的方案。
使用Map来记录序号，在遍及数组的时候，进行问题的求解。如果先遍历，存储到Map之后，再进行问题的求解，反而会加大问题的难度。

15. [3Sum](https://leetcode.com/problems/3sum/)

将数组进行排序之后，可以转换为2Sum来进行求解。

26. [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

遍历的过程中，记录重复元素的个数，然后将后续数字向前依次移动，并记录数组的动态长度。

27. [Remove Element](https://leetcode.com/problems/remove-element/)

遍历过程中，记录数组的动态长度。

153. [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

```java
private int findMin(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i + 1] < nums[i]) {
                index = i + 1;
                break;
            } 
        }
        if (index + 1 >= end) {
            return nums[index];
        } else {
            int min = findMin(nums, index + 1, end);
            return Math.min(min, nums[index]);
        }
        
    }
```  

289. [Game Of Life](https://leetcode.com/problems/game-of-life/)

要求不使用额外变量临时记录中间状态的话，考虑使用特征值的方法。所有的Cell都处理完成之后，再将特征值替换会原始的值。

例如，死亡的Cell -> 存活的Cell，这一过程的特征值为 2。存活的Cell -> 死亡的Cell，这一过程的特征值为 -1。在统计Cell周边存活Cell的个数的时候，需要统计值为-1的Cell。

791. [Custom Sort String](https://leetcode.com/problems/custom-sort-string/)

自定义排序，排序规则是在给定的字符串中。



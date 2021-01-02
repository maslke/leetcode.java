package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/richest-customer-wealth/
// 1672. 最富有客户的资产总量
// 垃圾题目

public class lc1672 {
    public int maximumWealth(int[][] accounts) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(accounts).forEach(r -> {
            int sum = Arrays.stream(r).sum();
            list.add(sum);
        });
        return list.stream().max(Integer::compareTo).get();
    }
}

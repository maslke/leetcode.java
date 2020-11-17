package medium;

// https://leetcode-cn.com/problems/swap-numbers-lcci/
// 面试题 16.01. 交换数字

public class lc16_01 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}

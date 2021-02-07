package easy;

// https://leetcode-cn.com/problems/sum-of-unique-elements/
// 6567. 唯一元素的和

public class lc5657 {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] visited = new int[101];
        for (int i = 0; i < nums.length; i++) {
            visited[nums[i]]++;
        }
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}

package easy;

// https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
// 1491. 去掉最低工资和最高工资后的工资平均值
// 打字模拟器

public class lc1491 {
    public double average(int[] salary) {
        int n = salary.length;
        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            if (max < salary[i]) {
                max = salary[i];
            }
            if (min > salary[i]) {
                min = salary[i];
            }
            sum += salary[i];
        }

        return (sum - max - min)  * 1.0 / (n - 2);
    }
}

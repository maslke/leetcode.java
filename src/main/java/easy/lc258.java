package easy;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 258. Add Digits
 */
public class lc258 {
    //O(1)的算法想不到，看了讨论
    public int addDigits(int num) {
        while (num >= 10) {
            int ret = 0;
            while(num > 0) {
                ret += num % 10;
                num = num / 10;
            }
            num = ret;
        }
        return num;
       // return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}

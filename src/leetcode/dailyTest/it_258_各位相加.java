package leetcode.dailyTest;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 */
public class it_258_各位相加 {
    public static void main(String[] args) {
        int num = 38;
        int res = new it_258_各位相加().addDigits(num);
        System.out.println(res);
    }

    public int addDigits(int num) {
        int res = 0;
        while (num > 0) {
            res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
            if (num < 10) {
                return res;
            }
        }
        return res;
    }
}

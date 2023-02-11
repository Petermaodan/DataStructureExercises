package jianzhioffer2;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 * 思路，用减法解决
 */
public class it_01_整数除法 {
    public static void main(String[] args) {
        int a=15,b=2;
        int res = new it_01_整数除法().divide(a, b);
        System.out.println(res);
    }

    //类似于快速幂的优化
    private int divide(int a, int b) {
        int sign=(a>0)^(b>0)?-1:1;
        if (a==Integer.MIN_VALUE&&b==-1){
            return Integer.MAX_VALUE;
        }
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a<=b){
            int value=b;
            int k=1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
            // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
            // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            // -2^31 / 2 = -2^30
            while (value>0xc0000000&&a<=value+value){
                value+=value;
                k+=k;
            }
            a-=value;
            res+=k;
        }
        return sign==1?res:-res;
    }

    public int divide2(int a, int b) {
        int sign=(a>0)^(b>0)?-1:1;
        if (a==Integer.MIN_VALUE&&b==-1){
            return Integer.MAX_VALUE;
        }
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign==1?res:-res;
    }
}

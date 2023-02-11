package leetcode.hot100;

/**
 * 当 x = 0.0x=0.0 时：直接返回 0.00.0 ，以避免后续 11 除以 00 操作报错。分析： 数字 00 的正数次幂恒为 00 ； 00 的 00 次幂和负数次幂没有意义，因此直接返回 0.00.0 即可。
 * 初始化 res = 1res=1 。
 * 当 n < 0n<0 时：把问题转化至 n \geq 0n≥0 的范围内，即执行 x = 1/xx=1/x ，n = - nn=−n 。
 * 循环计算：当 n = 0n=0 时跳出。
 * 当 n \& 1 = 1n&1=1 时：将当前 xx 乘入 resres （即 res *= xres∗=x ）。
 * 执行 x = x^2x=x
 * 2
 *   （即 x *= xx∗=x ）。
 * 执行 nn 右移一位（即 n >>= 1n>>=1）。
 * 返回 resres 。
 *
 * 思路，使用快速幂和迭代的方式解决
 * 需要将器其分解，比如99^2345可以分解为
 * 99^(234∗10)∗99^5=(99^234)^10∗99^5

 */
public class it_50_快速幂 {
    public static void main(String[] args) {
        double x=2.0;
        int n=10;
        double res = new it_50_快速幂().myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x,int n){
        if (x==0.0f)return 0.0d;
        long b= n;
        double res=1.0;
        if (b<0){
            x=1/x;
            b=-b;
        }
        while (b>0){
            if ((b&1)==1)res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}

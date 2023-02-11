package leetcode.hot100;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class it_29_两数相除 {
    public static void main(String[] args) {
        int dividend=2147483647,divisor=2;
        int res = new it_29_两数相除().divide(dividend, divisor);
        System.out.println(res);
    }
    public int divide(int dividend,int divisor){
        if (divisor==0)return 0;
        if (divisor==1)return dividend;
        if (divisor==-1){
            return dividend>Integer.MIN_VALUE?-dividend:Integer.MAX_VALUE;
        }
        long a=dividend;
        long b=divisor;
        int sign=1;
        if ((a>0&&b<0)||(a<0&&b>0)){
            sign=-1;
        }
        a=a>0?a:-a;
        b=b>0?b:-b;
        int res=div(a,b);
        if (sign>0){
            return res>Integer.MAX_VALUE?Integer.MAX_VALUE:res;
        }
        return -res;
    }

    private int div(long a, long b) {
        if (a<b)return 0;
        long tempB=  b;
        int count=1;
        while (tempB+tempB<=a){
            count+=count;
            tempB+=tempB;
        }
        return count+div(a-tempB,b);
    }
}

package jianzhioffer2;

/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 */
public class it_72_求平方根 {
    public static void main(String[] args) {
        int res = new it_72_求平方根().mySqrt(2147483647);
        System.out.println(res);
    }
    public int mySqrt(int x) {
        int l=0,r= Math.min(x, Integer.MAX_VALUE / 2);
        while (l<r){
            int mid=(l+r+1)/2;
            if ((long)mid*mid<=x){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        return l;
    }
}

package jianzhioffer;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001
 * ，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *

 */

public class it_15_二进制中1的个数 {
    public static void main(String[] args) {
        int n=00000000000000000000000000001011;
        int result=new it_15_二进制中1的个数().hammingWeight(n);
        System.out.println(result);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //通过判断n&1是否为1逐个计算
//        int res=0;
//        for (int i = 0; i < 32; i++) {
//            if ((n&1)==1){
//                res++;
//
//            }
//            n=n>>1;
//        }
//        return res;

        //方法二，巧用（n-1）
        int res=0;
        while (n!=0){
            res++;
            n&=(n-1);
        }
        return res;


    }
}

package jianzhioffer2;

import BaseUtil.ListUtil;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。

 * 示例 1:
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * 示例 2:
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 动态规划思路
 * 对于所有的数字，只有奇数和偶数两种：
 *
 * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
 * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
 * 所以我们可以得到如下的状态转移方程：
 *
 * dp[i] = dp[i-1]+1，当i为奇数
 * dp[i] = dp[i/2]，当i为偶数
 *

 */
public class it_03_前n个数字二进制中1的个数 {
    public static void main(String[] args) {
        int n=5;
        int[] ints = new it_03_前n个数字二进制中1的个数().countBits(n);
        ListUtil.arrayOneNums(ints);
    }

    private int[] countBits(int n) {
        int[] res=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            res[i]=i%2==1?res[i-1]+1:res[i/2];
        }
        return res;
    }

    public int[] countBits2(int n) {
        int[] res=new int[n+1];
        for (int i = 0; i <=n; i++) {
            int temp=i;
            int count=0;
            while (temp>0){
                count+=(temp&1);
                temp>>=1;
            }
            res[i]=count;
        }
        return res;
    }
}

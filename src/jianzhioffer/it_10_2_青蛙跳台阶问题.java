package jianzhioffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class it_10_2_青蛙跳台阶问题 {
    public static void main(String[] args) {
        int n=0;
        System.out.println(new it_10_2_青蛙跳台阶问题().numWays(n));
    }

    public int numWays(int n) {
        if (n==0||n==1)return 1;
        //base case:
        int dp_i_1=1,dp_i_2=2;
        for (int i = 3; i <= n; i++) {
            int tmp=(dp_i_1+dp_i_2)%1000000007;
            dp_i_1=dp_i_2;
            dp_i_2=tmp;
        }
        return dp_i_2;

    }
}

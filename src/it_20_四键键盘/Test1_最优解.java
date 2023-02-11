package it_20_四键键盘;

import java.util.Scanner;

/**
 * 特殊的四键键盘键盘->给定操作次数，如何才能使屏幕上A最多，
 * 四种操作分别为A、Ctrl-A->全选、Ctrl-c->复制、Ctrl-v->粘贴
 */
public class Test1_最优解 {
    public static void main(String[] args) {
        int N=new Scanner(System.in).nextInt();
        int result=new Test1_最优解().maxA(N);
        System.out.println(result);
    }

    private int maxA(int n) {
        int[] dp=new int[n+1];
        //base case:n=0时，只有0个A
        dp[0]=0;
        for (int i = 1; i <=n ; i++) {
            // 按 A 键
            dp[i]=dp[n-1]+1;
            for (int j = 2; j <i ; j++) {
                // 全选 & 复制 dp[j-2]， 连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i]=Math.max(dp[i],dp[j-1]*(i-j+1));
            }
        }
        // N 次按键之后最多有⼏个 A？
        return dp[n];
    }
}

package it_06_dp;

import java.util.Scanner;

public abstract class Test3_dp {
    public static void main(String[] args) {

        System.out.println(fib(0));
    }

//    private static int fib(int n) {
//        if(n==0){
//            return 0;
//        }
//        int[] dp=new int[n+1];
//        dp[1]=dp[2]=1;
//        for (int i = 3; i <n+1 ; i++) {
//            dp[i]=dp[i-1]+dp[i-2];
//            dp[i]%=1000000007;
//        }
//        return dp[n];
//    }
    private static int fib(int n){
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    };

}

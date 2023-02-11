package it_06_dp;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        System.out.println(fib(N));
    }

    private static int fib(int n) {
        if(n<1){
            return 0;
        }
        int[] memo=new int[n+1];
        return helper(memo,n);
    }

    private static int helper(int[] memo, int n) {
        if (n==1||n==2){
            return 1;
        }
        if (memo[n] !=0){
            return memo[n];
        }
        memo[n]=(helper(memo,n-1)+helper(memo,n-2));
        return memo[n]%1000000007;
    }
}

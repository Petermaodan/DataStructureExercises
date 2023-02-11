package leetcode.hot100;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是
 *
 */
public class it_279_完全平方数 {
    public static void main(String[] args) {
        int n=12;
        int res=new it_279_完全平方数().numSquares(n);
        System.out.println(res);
    }

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        //初始化数组
        Arrays.fill(dp,Integer.MAX_VALUE);
        //base case
        dp[0]=0;

        //构建一个n的完全平方数列表
        int max_num_square= (int) Math.sqrt(n)+1;
        int[] num_squares=new int[max_num_square];
        for (int i = 1; i < max_num_square; i++) {
            num_squares[i]=i*i;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < max_num_square; j++) {
                if (i<num_squares[j]){
                    break;
                }
                //选择：
                dp[i]=Math.min(dp[i],dp[i-num_squares[j]]+1);
            }
        }
        return dp[n];
    }
}

package it_09_股票买卖;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *

 */
public class maxProfit_k_2 {
    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        int[] n1={1,3,2,8,4,9};
        int[] n2={3,3,5,0,0,3,1,4};
        int result = maxProfit(n2);
        System.out.println(result);
        System.out.println("=========");
        int result2=maxProfit2(n2);
        System.out.println(result2);
    }

    private static int maxProfit2(int[] prices) {
        int dp_i_20=0,dp_i_21= (int) (-1/0.0);
        int dp_i_10=0,dp_i_11= (int) (-1/0.0);
        for (int price : prices) {
            dp_i_20=Math.max(dp_i_20,dp_i_21+price);
            dp_i_21=Math.max(dp_i_21,dp_i_10-price);
            dp_i_10=Math.max(dp_i_10,dp_i_11+price);
            dp_i_11=Math.max(dp_i_11,-price);
        }

        return dp_i_20;
    }

    private static int maxProfit(int[] prices) {
        int n=prices.length;
        if (n==0){
            return 0;
        }
        int k_max=2;
        int [][][] dp=new int[n][k_max+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = k_max; k >=1 ; k--) {
                if (i==0){
                    dp[0][k][0]=0;
                    dp[0][k][1]=-prices[0];
                    continue;//continue特别关键，不然就会遇到i-1<0的情况,实际上就是base case
                }
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][k_max][0];

    }
}

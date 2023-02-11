package it_09_股票买卖;

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class maxProfit_k_inf {
    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        int[] n1={};
        int result = maxProfit(n);
        System.out.println(result);
        System.out.println("=========");
        int result2=maxProfit2(n);
        System.out.println(result2);

    }

    private static int maxProfit2(int[] prices) {
        int n=prices.length;
        int dp_i_0=0,dp_i_1= (int) (-1/0.0);//初始化
        for (int i = 0; i < n; i++) {
            int temp=dp_i_0; //这里需要一个中间变量，因为dp_i_0在下一步会更新
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,temp-prices[i]);
        }
        return dp_i_0;
    }

    public static int maxProfit(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}

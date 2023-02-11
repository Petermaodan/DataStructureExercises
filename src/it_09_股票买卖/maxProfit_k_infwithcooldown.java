package it_09_股票买卖;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

 */
public class maxProfit_k_infwithcooldown {
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
        int d_i_0=0,d_i_1= (int) (-1/0.0);//初始化
        int d_pre_0=0;
        for (int i = 0; i < n; i++) {
            int temp=d_i_0;
            d_i_0=Math.max(d_i_0,d_i_1+prices[i]);
            d_i_1=Math.max(d_i_1,d_pre_0-prices[i]);
            d_pre_0=temp; //d_pre_0为之前两个的值，因为要将冷静期跳过
        }
        return d_i_0;
    }

    private static int maxProfit(int[] prices) {
        int n=prices.length;
        if (n<=1){
            return 0;
        }
        int[][] dp=new int[n][2];
        //base case:
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1],-prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}

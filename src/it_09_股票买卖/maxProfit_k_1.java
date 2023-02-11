package it_09_股票买卖;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class maxProfit_k_1 {
    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        int[] n1={};
        int result = maxProfit(n);
        System.out.println(result);

    }
    //新状态只和相邻的⼀个状态有关， 其实不⽤整个 dp 数组， 只需要
    // 个变量储存相邻的那个状态就⾜够了， 这样可以把空间复杂度降到 O(1)

    public static int maxProfit2(int[] prices){
        int n=prices.length;
        if (n==0){
            return 0;
        }
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0=0,dp_i_1= (int) (-1/0.0);
        for (int i = 0; i < n; i++) {
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int n = prices.length;
        //两种状态
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            //base case
            if (i - 1 == -1) {
                dp[i][0] = 0;
            // 解释：
            // dp[i][0]
            // = max(dp[-1][0], dp[-1][1] + prices[i])
            // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
            //解释：
            // dp[i][1]
            // = max(dp[-1][1], dp[-1][0] - prices[i])
            // = max(-infinity, 0 - prices[i])
            // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}

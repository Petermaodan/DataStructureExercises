package it_09_股票买卖;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 */
public class maxProfit_k_infwithfee {
    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        int[] n1={1,3,2,8,4,9};//用例通不过？
        int result = maxProfit(n1,2);
        System.out.println(result);
        System.out.println("=========");
        int result2=maxProfit2(n1,2);
        System.out.println(result2);
    }

    private static int maxProfit2(int[] prices,int fee) {
        int n=prices.length;
        if (n==0){
            return 0;
        }
        int dp_i_0=0,dp_i_1= (int) (-1/0.0);
        for (int i = 0; i < n; i++) {
            int temp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,temp-prices[i]-fee);
        }
        return dp_i_0;
    }

    private static int maxProfit(int[] prices,int fee) {
        int n=prices.length;
        if (n==0){
            return 0;
        }
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0]-fee;
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }
}

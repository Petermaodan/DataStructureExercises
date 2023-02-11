package leetcode.hot100;
/**给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0


 */
public class it_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        System.out.println(new it_121_买卖股票的最佳时机().maxProfit(nums));
    }

    //新状态只和相邻的⼀个状态有关， 其实不⽤整个 dp 数组， 只需要
    // 个变量储存相邻的那个状态就⾜够了， 这样可以把空间复杂度降到 O(1)
    public int maxProfit(int[] prices) {
        //base case
        //dp[-1][k][0](未开始)=dp[i][0][0](未持有)=0
        //不可能的情况dp[-1][k][1]=dp[i][0][1]=-infinity
        int n=prices.length;
        int dp_i_0=0,dp_i_1=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }
}

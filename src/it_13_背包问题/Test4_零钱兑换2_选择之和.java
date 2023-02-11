package it_13_背包问题;

/**
 * 你想⽤⾯值为 2 的硬币凑出⾦额 5， 那么如果你知道了凑出⾦额 3
 * 的⽅法， 再加上⼀枚⾯额为 2 的硬币， 不就可以凑出 5 了嘛。
 * 综上就是两种选择， ⽽我们想求的 dp[i][j] 是「共有多少种凑法」 ， 所以
 * dp[i][j] 的值应该是以上两种选择的结果之和
 */
public class Test4_零钱兑换2_选择之和 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int result = new Test4_零钱兑换2_选择之和().change2(amount, coins);
        System.out.println(result);

    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //base case:
        //dp[..][0]=1--凑出的金额为零，无为而治，1种凑法
        //dp[0][..]=0--零个硬币不能凑
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    //如果我们加入硬币i的品种，首先我们需要知道的是，设总金额值减去硬币i的金额值=m，这个m在硬币种类包含i下，共有多少种办法，那么再
                    //给这每种办法的基础上再加一个硬币i的面值，就是硬币i的品种且总金额值为j。
                    //所以这里是dp[i][j-coins[i-1]]而不是dp[i-1][j-coins[i-1]]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    //降低空间复杂度
    public int change2(int amount,int[] coins){
        int n=coins.length;
        int[] dp=new int[amount+1];
        //base case:
        dp[0]=1;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                if (j-coins[i-1]>=0){
                    dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}

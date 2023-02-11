package it_09_股票买卖;

public class maxProfit_k_anyinteger {

    public static void main(String[] args) {
        int[] n = {7, 1, 5, 3, 6, 4};
        int[] n1 = {3, 2, 6, 5, 0, 3};
        int[] n2={};
        int[] n3={3,3,5,0,0,3,1,4};
        int result = maxProfit(2, n3);
        System.out.println(result);
        System.out.println("=========");
        int result2 = maxProfit2(2, n3);
        System.out.println(result2);

    }
//优化失败-------
    private static int maxProfit2(int k, int[] prices) {
        int n=prices.length;
        if(n==0||prices==null){
            return 0;
        }
        if (k>n/2){
            int dp_i_0=0,dp_i_1= (int) (-1/0.0);
            for (int i = 0; i < n; i++) {
                int temp=dp_i_0;
                dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
                dp_i_1=Math.max(dp_i_1,temp-prices[i]);
            }
            return dp_i_0;
        }
        int k_max=k;
//        int dp_i10=0,dp_i11= (int) (-1/0.0);
        int dp_ik0=0,dp_ik1= (int) (-1/0.0);
        for (int i = 0; i < n; i++) {
            for (int j = k_max; j >=1 ; j--) {
                int temp=dp_ik0;
                dp_ik0=Math.max(dp_ik0,dp_ik1+prices[i]);
                dp_ik1=Math.max(dp_ik1,temp-prices[i]);
            }
        }
        return dp_ik0;
    }

    private static int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0||prices==null){
            return 0;
        }
        if (k>n/2){
            int[][] dp=new int[n][2];
            for (int i = 0; i < n; i++) {
                if (i==0){
                    dp[0][0]=0;
                    dp[0][1]=-prices[i];
                    continue;
                }
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }
            return dp[n-1][0];
        }
        int k_max=k;
        int[][][] dp=new int[n][k_max+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k_max; j >=1 ; j--) {
                if (i==0){
                    dp[0][j][0]=0;
                    dp[0][j][1]=-prices[i];
                    continue;
                }
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }

        return dp[n-1][k_max][0];
    }
}

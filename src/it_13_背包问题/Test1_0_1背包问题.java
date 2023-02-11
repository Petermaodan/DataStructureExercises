package it_13_背包问题;

import BaseUtil.ListUtil;

public class Test1_0_1背包问题 {
    public static void main(String[] args) {
        int N = 3, W = 4;

        //
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        int result = knapsack(W, N, wt, val);
        int result2 = knapsack2(W, N, wt, val);
        System.out.println(result + " " + result2);
    }

    private static int knapsack2(int w, int n, int[] wt, int[] val) {
        int[] dp = new int[w + 1];
        int[][] g = new int[n + 1][w + 1];
        for (int i = 0; i <n; i++) {
            for (int j = w; j >= wt[i]; j--) {
                g[i][j]=0;
                if (dp[j]<dp[j - wt[i]] + val[i]){
                    dp[j]=dp[j - wt[i]] + val[i];
                    g[i][j]=1;
                }
            }
        }

        int i = wt.length, V = w;
        ListUtil.arrayTowNums(g);
        System.out.println();
        while (i >= 0) {
            if (g[i][V] == 0) {
                i--;
            } else {
                System.out.print(i + " ");
                V -= wt[i];
                i--;
            }
        }


        return dp[w];
    }

    private static int knapsack(int w, int n, int[] wt, int[] val) {
        // 二维数组：状态定义:dp[i][j]表示从0-i个物品中选择不超过j重量的物品的最大价值
        int[][] dp = new int[n + 1][w + 1];
        int[][] g = new int[n + 1][w + 1];
        //base case
        // 初始化:第一列都是0，第一行表示只选取0号物品最大价值
        for (int j = w; j >= wt[0]; j--) {
            dp[0][j] = dp[0][j - wt[0]] + val[0];
//            System.out.println(dp[0][j]);
            g[0][j] = 1;
        }


        for (int i = 1; i < wt.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < wt[i]) {
                    //当前背包装不下，只能选择不装入背包
                    dp[i][j] = dp[i - 1][j];
                    g[i][j] = 0;
                } else {
                    //装入或者不装择优选择
//                    dp[i][j]=Math.max(dp[i-1][j-wt[i]]+val[i],dp[i-1][j]);
                    if (dp[i - 1][j - wt[i]] + val[i] >= dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - wt[i]] + val[i];
                        g[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        g[i][j] = 0;
                    }
                }
            }
        }


        int i = wt.length, V = w;
        ListUtil.arrayTowNums(g);
        System.out.println();
        while (i >= 0) {
            if (g[i][V] == 0) {
                i--;
            } else {
                System.out.print(i + " ");
                V -= wt[i];
                i--;
            }
        }

        return dp[n - 1][w];
    }
}

package jianzhioffer2;

/**
 *如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 *
 * 当只有第 0 号房子被粉刷时，对于每一种颜色，总花费成本即为将第 0号房子粉刷成该颜色的花费成本，因此边界条件是：
 * 对于任意  j < 30≤j<3,dp[0][j]=costs[0][j]。
 *对于i < n1≤i<n，第 i 号房子和第i−1 号房子的颜色必须不同，因此当第 i 号房子被粉刷成某一种颜色时，
 * 第 i−1 号房子只能被粉刷成另外两种颜色之一。当第 i 号房子分别被粉刷成三种颜色时，粉刷第 0 号房子到第 i 号房子的最小花费成本计算如下
 dp[i][0] =min(dp[i−1][1],dp[i−1][2])+costs[i][0]
 dp[i][1] =min(dp[i−1][0],dp[i−1][2])+costs[i][1]
 dp[i][2] =min(dp[i−1][0],dp[i−1][1])+costs[i][2]
 */
public class it_91_粉刷房子 {
    public static void main(String[] args) {
        int[][] costs={{17,2,17},{16,16,5},{14,3,19}};
        int res = new it_91_粉刷房子().minCost(costs);
        System.out.println(res);
    }

    public int minCost(int[][] costs) {
        int n=costs.length;
        int[][] dp=new int[n][3];
        //初始条件
        for (int i = 0; i < 3; i++) {
            dp[0][i]=costs[0][i];
        }
        //动态规划
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+costs[i][2];
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}

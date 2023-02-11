package it_06_dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 转移方程：之和左边和上边有关，所以f(i,j)=f(i-1,j)+f(i,j-1)
 */
public class it_62_不同路径 {
    public static void main(String[] args) {
        int res = new it_62_不同路径().uniquePaths(3, 7);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        //base case
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

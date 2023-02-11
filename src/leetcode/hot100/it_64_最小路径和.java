package leetcode.hot100;

/**
 * 与上题的不同路径解题思路相类似
 * 动态规划解决
 * 创建二维数组 {dp}dp，与原始网格的大小相同，{dp}[i][j]dp[i][j] 表示从左上角出发到 (i,j)(i,j) 位置的最小路径和。显然，{dp}[0][0]={grid}[0][0]dp[0][0]=grid[0][0]。对于 {dp}dp 中的其余元素，通过以下状态转移方程计算元素值。
 *
 * 当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
 *
 * 当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
 *
 * 当 i>0 且 j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
 *
 * 最后得到 {dp}[m-1][n-1]dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和。
 */
public class it_64_最小路径和 {
    public static void main(String[] args) {
       int[][]  grid = {{1,3,1},{1,5,1},{4,2,1}};
       int res=new it_64_最小路径和().minPathSum(grid);
        System.out.println(res);

    }
    public int minPathSum(int[][] grid) {
        //base case:
        int m=grid.length;
        int n=grid[0].length;
        //base case:
        if (grid==null||m==0||n==0){
            return 0;
        }
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        //动态规划
        //当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
        for (int i = 1; i < m; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
        for (int j = 1; j <n ; j++) {
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        //当 i>0 且 j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}


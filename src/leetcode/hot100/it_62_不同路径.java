package leetcode.hot100;

/**
 * 我们用 f(i, j)f(i,j) 表示从左上角走到 (i, j)(i,j) 的路径数量，其中 ii 和 jj 的范围分别是 [0, m)[0,m) 和 [0, n)[0,n)。
 *
 * 由于我们每一步只能从向下或者向右移动一步，因此要想走到 (i, j)(i,j)，如果向下走一步，那么会从 (i-1, j)(i−1,j) 走过来；如果向右走一步，那么会从 (i, j-1)(i,j−1) 走过来。因此我们可以写出动态规划转移方程：
 *
 * f(i, j) = f(i-1, j) + f(i, j-1)
 * f(i,j)=f(i−1,j)+f(i,j−1)
 *
 * 需要注意的是，如果 i=0i=0，那么 f(i-1,j)f(i−1,j) 并不是一个满足要求的状态，我们需要忽略这一项；同理，如果 j=0j=0，那么 f(i,j-1)f(i,j−1) 并不是一个满足要求的状态，我们需要忽略这一项。
 *
 * 初始条件为 f(0,0)=1f(0,0)=1，即从左上角走到左上角有一种方法。
 *
 * 最终的答案即为 f(m-1,n-1)f(m−1,n−1)。

 */
public class it_62_不同路径 {
    public static void main(String[] args) {
        int m=3,n=7;
        int res=new it_62_不同路径().uniquePaths(m,n);
        System.out.println(res);
    }
    public int uniquePaths(int m, int n) {
        //base case
        int[][] dp=new int[m][n];
        for (int i = 0; i <m; i++) {
            dp[i][0]=1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                //f(i, j) = f(i-1, j) + f(i, j-1)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

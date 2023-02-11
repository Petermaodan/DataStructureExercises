package leetcode.hot100;

/**
 *在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 *
 *
 * 思路：
 * 定义 f[i][j][p] 为从位置(i,j) 出发，使用步数不超过 p 步，最后仍在棋盘内的概率。
 *
 * 不失一般性考虑f[i][j][p] 该如何转移，根据题意，移动规则为「八连通」，对下一步的落点 (nx,ny) 进行分情况讨论即可：
 *
 * 由于计算的是仍在棋盘内的概率，因此对于 (nx,ny) 在棋盘外的情况，无须考虑；
 * 若下一步的落点 (nx,ny) 在棋盘内，其剩余可用步数为 p−1，则最后仍在棋盘的概率为f[nx][ny][p−1]，
 * 则落点(nx,ny) 对 f[i][j][p] 的贡献为 f[nx][ny][p - 1] /8
 *   为事件「从 (i,j) 走到 (nx,ny)」的概率（八连通移动等概率发生），该事件与「到达(nx,ny) 后进行后续移动并留在棋盘」为相互独立事件。
 * 最终的f[i][j][p] 为「八连通」落点的概率之和，即有：f[i][j][p]=∑f[nx][ny][p−1]/8
 *
 */
public class it_688_骑士在棋盘上的概率_线性DP {
    public static void main(String[] args) {
        int n=3,k=2,row=0,column=0;
        double v = new it_688_骑士在棋盘上的概率_线性DP().knightProbability(n, k, row, column);
        System.out.println(v);
    }
    int[][] dirs={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[n][n][k+1];
        //将所有概率初始值设为1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0]=1;
            }
        }

        //dp枚举每个点作为起始点的可能性
        for (int p = 1; p <=k ; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //枚举8个联通量
                    for (int[] dir : dirs) {
                        int newI=i+dir[0],newJ=j+dir[1];
                        if (newI<0||newI>=n||newJ<0||newJ>=n){
                            continue;
                        }
                        dp[i][j][p]+=dp[newI][newJ][p-1]/8;
                    }
                }
            }
        }
        return dp[row][column][k];

    }
}

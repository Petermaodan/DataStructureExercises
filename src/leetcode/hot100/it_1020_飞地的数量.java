package leetcode.hot100;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 思路：先把边界上的1深度优先剔除掉，剩下的就是我们所求的飞地数量
 *
 */
public class it_1020_飞地的数量 {
    public static void main(String[] args) {
        int[][]grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int res = new it_1020_飞地的数量().numEnclaves(grid);
        System.out.println(res);
    }

    int m,n;
    boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        //寻找边界上的1
        for (int i = 0; i < m; i++) {
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for (int j = 1; j < n-1; j++) {
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int res=0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j]==1&&!visited[i][j]){
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (!isArea(grid,i,j)||grid[i][j]==0||visited[i][j])return;

        visited[i][j]=true;
        for (int[] dir : dirs) {
            dfs(grid,i+dir[0],j+dir[1]);
        }
    }

    private boolean isArea(int[][] grid, int i, int j) {
        return i>=0&&i<grid.length&&j>=0&&j<grid[0].length;
    }
}

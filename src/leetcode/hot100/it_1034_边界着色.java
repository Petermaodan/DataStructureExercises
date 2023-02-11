package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 这是一道结合「阅读理解」的常规图论搜索题。
 *
 * 基本题意为：从题目给定的 (row, col) 进行出发，如果遍历到「连通分量的边界」格子，则使用 color 进行上色。
 *
 * 同一「连通分量」的「非边界」格子满足：当前格子的四联通方向均存在相邻格子，且当前格子与四联通相邻格子颜色一致。
 *
 * 也就是说，我们从 (row, col) 进行出发，遍历 (row,col) 所在的「连通分量」，如果遍历到的「连通分量」格子不满足上述条件（边界格子），则进行上色
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 * 本题和岛屿数量很类似，唯一不同点在于如何判断联通分量的边界，可以通过一个count来统计是否不在边界上，边界的定义如下
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *

 */
public class it_1034_边界着色 {
    public static void main(String[] args) {
        int[][]grid = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] res = new it_1034_边界着色().colorBorder(grid, 1, 1, 2);
        ListUtil.arrayTowNums(res);
    }

    int row,col,color;
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int[][] grid,ans;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.row=row;
        this.col=col;
        this.color=color;
        this.grid=grid;
        int m=grid.length,n=grid[0].length;
        ans=new int[m][n];
        dfs(row,col);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j]==0)ans[i][j]=grid[i][j];
            }
        }
        return ans;
    }

    private void dfs(int x, int y) {
        int count=0;
        for (int[] dir : dirs) {
            int newX=x+dir[0],newY=y+dir[1];
            if (!isArea(grid,newX,newY)){
                continue;
            }
            if (grid[x][y]!=grid[newX][newY]){
                continue;
            }else {
                count++;
            }
            if (ans[newX][newY]==-1)continue;
            ans[newX][newY]=-1;
            dfs(newX,newY);
        }
        //这里判断x,y四周的联通分量是否都存在
        ans[x][y]=count==4?grid[x][y]:color;
    }

    private boolean isArea(int[][] grid, int x, int y) {
        return x>=0&&x<grid.length&&y>=0&&y<grid[0].length;
    }
}

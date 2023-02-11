package it_02_BFSDFS;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 */

public class it_200_岛屿数量 {
    public static void main(String[] args) {


    }

    int res=0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    //DFS该点
                    dfsGrid(grid,i,j);
                    //连成片的遍历完成
                    res++;
                }
            }
        }
        return res;
    }

    public void dfsGrid(char[][] grid, int i, int j) {
        //base case,超出边界，直接返回
        if (!isArea(grid,i,j)){
            return;
        }
        if (grid[i][j]!='1')return;
        //标记
        grid[i][j]='2';

        //DFS
        dfsGrid(grid,i+1,j);
        dfsGrid(grid,i-1,j);
        dfsGrid(grid,i,j-1);
        dfsGrid(grid,i,j+1);
    }

    public boolean isArea(char[][] grid, int i, int j) {
        return i>=0&&i<grid.length&&j>=0&&j<grid[0].length;
    }
}

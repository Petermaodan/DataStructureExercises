package it_02_BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。

 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 *

 */
public class it_1091_二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        int [][] grid={{0,1,1,1,1,1,1,1},{0,1,1,0,0,0,0,0},{0,1,0,1,1,1,1,0},{0,1,0,1,1,1,1,0},{0,1,1,0,0,1,1,0},{0,1,1,1,1,0,1,0},{0,0,0,0,0,1,1,0},{1,1,1,1,1,1,1,0}};
        int res=new it_1091_二进制矩阵中的最短路径().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
    int[][] d={{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1},{0,1},{0,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if (grid[0][0]!=0||grid[n-1][m-1]!=0)return -1;
        if (m==1&&grid[0][0]==0)return 1;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        //标记数组
        int [][] visited=new int[n][m];
        visited[0][0]=1;
        //理论起始值的初始值
        int step=1;
        while (!queue.isEmpty()){
            int l=queue.size();
            for (int i = 0; i < l; i++) {
                int[] temp=queue.poll();
                int x=temp[0];
                int y=temp[1];
                for (int j = 0; j < 8; j++) {
                    int X=x+d[j][0];
                    int Y=y+d[j][1];
                    if (X<n&&X>=0&&Y>=0&&Y<m&&grid[X][Y]==0&&visited[X][Y]!=1){
                        queue.add(new int[]{X,Y});
                        visited[X][Y]=1;
                    }
                }
                if (x==n-1&&y==m-1)return step;

            }
            step++;
        }
        return -1;
    }
}

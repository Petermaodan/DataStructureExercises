package leetcode.dailyTest;

import BaseUtil.ListUtil;

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 *
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 *
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 */
public class it_661_图片平滑器 {
    public static void main(String[] args) {
        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        int[][] ints = new it_661_图片平滑器().imageSmoother(img);
        ListUtil.arrayTowNums(ints);
    }

    int[][] dirs={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    int m,n;
    int[][] tempImg;
    public int[][] imageSmoother(int[][] img) {
        m=img.length;
        n=img[0].length;
        tempImg=img;
        int[][] res=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp=img[i][j];
                res[i][j]=find(i,j,temp);
            }
        }
        return res;
    }

    private int find(int i, int j, int sum) {
        int count=1;
        for (int[] dir : dirs) {
            int newi=i+dir[0],newj=j+dir[1];
            if (isArea(newi,newj)){
                sum+=tempImg[newi][newj];
                count++;
            }
        }
        return sum/count;
    }

    private boolean isArea(int newi, int newj) {
        return newi>=0&&newi<m&&newj>=0&&newj<n;
    }
}

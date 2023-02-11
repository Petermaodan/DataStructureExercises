package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class it_59_螺旋矩阵2 {
    public static void main(String[] args) {
        int n=3;
        int[][] matrix = new it_59_螺旋矩阵2().generateMatrix(n);
        ListUtil.arrayTowNums(matrix);
    }

    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int t=0,b=res.length-1,l=0,r=res[0].length-1;
        int x=1;
        while (true){
            for (int i = l; i <=r; i++) {
                res[t][i]=x++;
            }
            if (++t>b)break;
            for (int i = t; i <=b ; i++) {
                res[i][r]=x++;
            }
            if (--r<l)break;
            for (int i = r; i >=l ; i--) {
                res[b][i]=x++;
            }
            if (--b<t)break;
            for (int i = b; i >=t ; i--) {
                res[i][l]=x++;
            }
            if (++l>r)break;
        }
        return res;
    }
}

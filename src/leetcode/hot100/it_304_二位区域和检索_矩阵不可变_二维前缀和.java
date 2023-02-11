package leetcode.hot100;

import jianzhioffer2.it_13_二维子矩阵的和_前缀和;

public class it_304_二位区域和检索_矩阵不可变_二维前缀和 {
    public static void main(String[] args) {
        int[][] matrix={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix=new NumMatrix(matrix);
        int res = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(res);
    }

    static class NumMatrix {

        int[][] sum;
        public NumMatrix(int[][] matrix) {
            int m=matrix.length,n=matrix[0].length;
            //计算前缀和
            sum=new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                int preSum=0;
                for (int j = 0; j < n; j++) {
                    preSum+=matrix[i][j];
                    //上一行加上本行
                    sum[i+1][j+1]=sum[i][j+1]+preSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2+1][col2+1]-sum[row1][col2+1]-sum[row2+1][col1]+sum[row1][col1];
        }
    }
}

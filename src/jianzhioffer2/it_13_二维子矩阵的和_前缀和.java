package jianzhioffer2;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 *

 */
public class it_13_二维子矩阵的和_前缀和 {
    public static void main(String[] args) {
        int[][] matrix={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix=new NumMatrix(matrix);

    }
    static class NumMatrix {
        //辅助矩阵，记录前缀和
        int[][] sums;
        public NumMatrix(int[][] matrix) {
            if (matrix.length==0||matrix[0].length==0){
                return;
            }
            //计算每行的前缀和
            sums=new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                int preSum=0;
                for (int j = 0; j < matrix[0].length; j++) {
                    preSum+=matrix[i][j];
                    //前一行的和加上当前位置的和
                    sums[i+1][j+1]=sums[i][j+1]+preSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
        }
    }
}

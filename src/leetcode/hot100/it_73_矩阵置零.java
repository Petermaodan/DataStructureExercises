package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class it_73_矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new it_73_矩阵置零().setZeroes(matrix);
        ListUtil.arrayTowNums(matrix);
    }


    //优化解法
    //思路二: 用O(1)O(1)空间
    //
    //关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位
    //
    //但是对于第一行,和第一列要设置一个标志位,为了防止自己这一行(一列)也有0的情况.注释写在代码里,直接看代码很好理解!
    //
    private void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag_row=false;
        boolean flag_col=false;

        //先判断第一行和第一列有无0存在
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flag_row = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag_col = true;
                break;
            }
        }

        //关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        //遍历标记，置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        //将第一行第一列置0
        if (flag_row){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
        if (flag_col){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
    }


    public void setZeroes2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0 && !flag[i][j]) {
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] == 0) continue;
                        matrix[i][k] = 0;
                        flag[i][k] = true;

                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] == 0) continue;
                        matrix[k][j] = 0;
                        flag[k][j] = true;
                    }
                }
            }
        }
    }
}

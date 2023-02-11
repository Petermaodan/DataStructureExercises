package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 *当 nn 为偶数时，我们需要枚举 n^2 / 4 = (n/2) \times (n/2)n
 * 2
 *  /4=(n/2)×(n/2) 个位置，可以将该图形分为四块
 *
 当 nn 为奇数时，由于中心的位置经过旋转后位置不变，我们需要枚举 (n^2-1) / 4 = ((n-1)/2) \times ((n+1)/2)(n
 2
 −1)/4=((n−1)/2)×((n+1)/2) 个位置，需要换一种划分的方式

 */
public class it_48_旋转图像 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        ListUtil.arrayTowNums(matrix);
        System.out.println();

        new it_48_旋转图像().rotate(matrix);
        ListUtil.arrayTowNums(matrix);

    }

    public void rotate(int[][] matrix) {
        int n=matrix.length;

        //当n为偶数时，n/2=n/2,(n+1)/2=n/2;
        //当n为奇数时，n/2=(n-1)/2,(n+1)/2=(n+1)/2
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int tmep=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmep;
            }
        }
    }
}

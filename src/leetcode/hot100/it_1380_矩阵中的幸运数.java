package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 */
public class it_1380_矩阵中的幸运数 {
    public static void main(String[] args) {
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> list = new it_1380_矩阵中的幸运数().luckyNumbers(matrix);
        ListUtil.arrayOne(list);
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] rowMin=new int[n];
        int[] colMax=new int[m];
        for (int i = 0; i < n; i++) {
            int temp=Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                temp=Math.min(temp,matrix[i][j]);
            }
            rowMin[i]=temp;
        }

        for (int i = 0; i < m; i++) {
            int temp=Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                temp=Math.max(temp,matrix[j][i]);
            }
            colMax[i]=temp;
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val=matrix[i][j];
                if (val==rowMin[i]&&val==colMax[j]){
                    res.add(val);
                }
            }
        }
        return res;
    }
}

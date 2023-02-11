package jianzhioffer;

import BaseUtil.ListUtil;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 主要思路就是判断四个边界,和各种细节，一个死循环解决

 */
public class it_29_顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] res = new it_29_顺时针打印矩阵().spiralOrder(matrix);
        ListUtil.arrayOneNums(res);
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new int[]{};
        int n=matrix.length,m=matrix[0].length;
        int t=0,b=matrix.length-1,l=0,r=matrix[0].length-1;
        int[] res=new int[n*m];
        int x=0;
        while (true){
            for (int i = l; i <=r ; i++) {
                res[x++]=matrix[t][i];
            }
            if (++t>b)break;
            for (int i = t; i <=b ; i++) {
                res[x++]=matrix[i][r];
            }
            if (--r<l)break;
            for (int i = r; i >=l ; i--) {
                res[x++]=matrix[b][i];
            }
            if (--b<t)break;
            for (int i = b; i >=t ; i--) {
                res[x++]=matrix[i][l];
            }
            if (++l>r)break;
        }
        return res;

    }
}

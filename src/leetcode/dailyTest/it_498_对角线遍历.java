package leetcode.dailyTest;

import BaseUtil.ListUtil;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */
public class it_498_对角线遍历 {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int[] res = new it_498_对角线遍历().findDiagonalOrder(mat);
        ListUtil.arrayOneNums(res);
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int cnt=m*n;
        int[] res=new int[cnt];
        int i=0,j=0,k=0;
        int up=1;
        while (i<m&&j<n){
            res[k++]=mat[i][j];
            int newI,newJ;
            if (up==1){
                newI=i-1;
                newJ=j+1;
            }else {
                newI=i+1;
                newJ=j-1;
            }
            if (k<cnt&&(newI<0||newI>=m||newJ<0||newJ>=n)){
                //核心步骤
                if (up==1){
                    newI=j+1<n?i:i+1;
                    newJ=j+1<n?j+1:j;
                }else {
                    newI=i+1<m?i+1:i;
                    newJ=i+1<m?j:j+1;
                }
                up*=-1;
            }
            i=newI;
            j=newJ;
        }
        return res;
    }
}

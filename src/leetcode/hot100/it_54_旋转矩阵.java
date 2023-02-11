package leetcode.hot100;
/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class it_54_旋转矩阵 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new it_54_旋转矩阵().spiralOrder(matrix);
        ListUtil.arrayOne(list);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        while (true){
            for (int i = l; i <=r ; i++) {
                res.add(matrix[t][i]);
            }
            if (++t>b)break;
            for (int i = t; i <=b ; i++) {
                res.add(matrix[i][r]);
            }
            if (--r<l)break;
            for (int i = r; i >=l; i--) {
                res.add(matrix[b][i]);
            }
            if (--b<t)break;
            for (int i = b; i >=t ; i--) {
                res.add(matrix[i][l]);
            }
            if (++l>r)break;
        }
        return res;
    }
}

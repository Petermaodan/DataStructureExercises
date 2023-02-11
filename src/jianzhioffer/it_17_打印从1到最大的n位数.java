package jianzhioffer;

import BaseUtil.ListUtil;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class it_17_打印从1到最大的n位数 {
    public static void main(String[] args) {
        int[] res=new it_17_打印从1到最大的n位数().printNumbers(3);
        ListUtil.arrayOneNums(res);
    }
    public int[] printNumbers(int n) {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(9);
        }
        int max=Integer.valueOf(s.toString());
        int [] res=new int[max];
        for (int i = 0; i <max; i++) {
            res[i]=i+1;
        }
        return res;
    }
}

package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 *
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 *
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 *
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 *
 */
public class it_1317_将整数转换为两个无零整数的和 {
    public static void main(String[] args) {
        int n=2;
        int[] ints = new it_1317_将整数转换为两个无零整数的和().getNoZeroIntegers(n);

        ListUtil.arrayOneNums(ints);
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int A=i;
            int B=n-i;
            if (isNoZero(A)&&isNoZero(B)){
                return new int[]{A,B};
            }
        }
        return new int[]{-1,-1};
    }

    private boolean isNoZero(int n) {
        while (n>0){
            int temp=n%10;
            if (temp==0)return false;
            n/=10;
        }
        return true;
    }
}

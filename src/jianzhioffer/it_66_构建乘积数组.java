package jianzhioffer;

import BaseUtil.ListUtil;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class it_66_构建乘积数组 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        ListUtil.arrayOneNums(new it_66_构建乘积数组().constructArr(nums));
    }

    public int[] constructArr(int[] a) {
        if (a.length==0)return new int[0];
        int[] B=new int[a.length];
        B[0]=1;
        //迭代计算左下角
        for (int i = 1; i < a.length; i++) {
            B[i]=B[i-1]*a[i-1];
        }
        //迭代计算右上角
        int tmp=1;
        for (int i = a.length-2; i >=0 ; i--) {
            tmp*=a[i+1];
            B[i]*=tmp;
        }
        return B;

    }

}

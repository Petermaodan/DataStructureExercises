package jianzhioffer;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class it_46_把数字翻译成字符串 {
    public static void main(String[] args) {
        int a= 226;
        int res=new it_46_把数字翻译成字符串().translateNum(a);
        System.out.println(res);
    }

    public int translateNum(int num) {
        String s=String.valueOf(num);
        int n=s.length();
        int[] dp=new int[n+1];
        //base case
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            String temp=s.substring(i-2,i);
            dp[i]=temp.compareTo("10")>=0&&temp.compareTo("25")<=0?dp[i-2]+dp[i-1]:dp[i-1];
        }
        return dp[n];
    }

    //空间复杂度为1
//    public int translateNum(int num){
//        String s=String.valueOf(num);
//        //base case:
//        //dp[0]=1,dp[1]=1;
//        int a=1,b=1;
//        for (int i = 2; i <=s.length() ; i++) {
//            String temp=s.substring(i-2,i);
//            int c=temp.compareTo("10")>=0&&temp.compareTo("25")<=0?a+b:a;
//            //同时移动a和b
//            b=a;
//            a=c;
//
//        }
//        return a;
//    }
}

package leetcode.hot100;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 */
public class it_1218_最长定差子序列 {
    public static void main(String[] args) {
        int[] arr={1,5,7,8,5,3,4,2,1};
        int difference=-2;
        int res = new it_1218_最长定差子序列().longestSubsequence(arr, difference);
        System.out.println(res);
    }

    //用数组代替哈希表的方法
    private int longestSubsequence(int[] arr, int difference) {
        int res=0;
        int[] dp=new int[40001];
        for (int num : arr) {
            //数组下标不能为负数，所以要加上20000
            dp[num+20000]=dp[num+20000-difference]+1;
            res=Math.max(dp[num+20000],res);
        }
        return res;

    }


    //该方法超时
    public int longestSubsequence2(int[] arr, int difference) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]-arr[j]==difference){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}

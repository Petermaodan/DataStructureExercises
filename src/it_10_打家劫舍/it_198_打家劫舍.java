package it_10_打家劫舍;
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影
 * 响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *

 */

import java.util.Arrays;

public class it_198_打家劫舍 {
    public static void main(String[] args) {
        it_198_打家劫舍 r=new it_198_打家劫舍();
        int[] nums={2,7,9,3,1};
        int result=r.rob3(nums);
        System.out.println(result);
    }
    //将空间复杂度降为O(1)的动态规划方法
    private int rob3(int[] nums){
        int n=nums.length;
        int dp_i_1=0,dp_i_2=0;
        int dp_i_0=0;
        for (int i = n-1; i >=0 ; i--) {
            dp_i_0=Math.max(dp_i_1,nums[i]+dp_i_2);
            dp_i_2=dp_i_1;
            dp_i_1=dp_i_0;
        }
        return dp_i_0;
    }

    //自底向上的动态规划解法
    private int rob2(int[] nums){
        int n=nums.length;
        int[] dp=new int[n+2];
        //base case:
        dp[n]=0;
        dp[n+1]=0;
        for (int i = n-1; i >=0 ; i--) {
            dp[i]=Math.max(dp[i+1],(nums[i]+dp[i+2]));
        }
        return dp[0];
    }

    private int[] memo;
    private  int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);//将指定的int值分配给指定的int数组的每个元素。
        return dp2(nums,0);
    }

    //备忘录记录优化
    private  int dp2(int[] nums, int start) {

        if (start>=nums.length){
            return 0;
        }
        if (memo[start]!=-1){
            return memo[start];
        }
        int res=Math.max(dp2(nums,start+1),(nums[start]+dp2(nums, start+2)));
        memo[start]=res;
        return res;

    }

    private static int dp(int[] nums, int start) {
        if (start>=nums.length){
            return 0;
        }
        int res=Math.max(dp(nums,start+1),(nums[start]+dp(nums,start+2)));
        return res;
    }
}

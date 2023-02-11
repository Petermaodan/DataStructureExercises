package it_06_dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class it_213_打家劫舍2 {
    public static void main(String[] args) {
        int[] nums={1,2};
        int result=new it_213_打家劫舍2().rob(nums);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0)return 0;
        if (n==1)return nums[0];

        return Math.max(dp(nums,0,n-2),dp(nums,1,n-1));


    }

    private int dp(int[] nums, int start, int end) {
        int n=nums.length;
        int[] dp=new int[n+2];
        //base case
        dp[n]=0;
        dp[n+1]=0;

        for (int i = end; i >=start; i--) {
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        return dp[start];
    }
}

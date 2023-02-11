package it_10_打家劫舍;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 环形数组
 *
 */
public class it_213_打家劫舍2 {
    public static void main(String[] args) {
        it_213_打家劫舍2 r=new it_213_打家劫舍2();
        int[] nums={1,2,3,1};
        int result=r.rob3(nums);
        System.out.println(result);
    }

    private int rob3(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        //其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。
        return Math.max(dp1(nums,0,n-2),dp1(nums,1,n-1));
    }

    private int dp1(int[] nums, int start, int end) {
        int n=nums.length;
        int[] dp=new int[n+2];
        dp[n]=0;
        dp[n+1]=0;
        for (int i = end; i >=start ; i--) {
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[0];
    }

    private int dp(int[] nums, int start, int end) {
        int dp_i_1=0,dp_i_2=0;
        int dp_i_0=0;
        for (int i = end; i >=start ; i--) {
            dp_i_0=Math.max(dp_i_1,nums[i]+dp_i_2);
            dp_i_2=dp_i_1;
            dp_i_1=dp_i_0;
        }
        return dp_i_0;
    }

}

package it_13_背包问题;

/**
 * 416
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */

public class Test2_子集背包问题 {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        boolean result=canPartition(nums);
        System.out.println(result);

    }
    public static boolean canPartition2(int[] nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int n=nums.length;
        sum=sum/2;
        boolean[] dp=new boolean[sum+1];
        //base case:
        dp[0]=true;//dp[i][0]--背包装满了
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >0 ; j--) {
                if (j-nums[i-1]>=0) {
                    dp[j]=dp[j]||dp[j-nums[i-1]];
                } else {
                    dp[j]=dp[j];
                }
            }
        }
        return dp[sum];

    }
    public static boolean canPartition(int[] nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int n=nums.length;
        sum=sum/2;
        boolean[][] dp= new boolean[n + 1][sum + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < sum; j++) {
//                dp[i][j]=false;
//            }
//        }

        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j-nums[i-1]<0){
                    //背包容量不足
                    dp[i][j]=dp[i-1][j];
                }else {
                    //背包容量充足
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}

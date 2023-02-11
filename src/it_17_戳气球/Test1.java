package it_17_戳气球;

public class Test1 {
    public static void main(String[] args){
        int nums[]={3,1,5,8};
        int result=new Test1().maxCoins(nums);
        System.out.println(result);
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] points=new int[n+2];
        // 添加两侧的虚拟气球,新的列队points
        for (int i = 1; i <=n ; i++) {
            points[i]=nums[i-1];
        }
        points[0]=points[n+1]=1;
        // 开始状态转移
        // i 应该从下往上
        for (int i = n+1; i >=0 ; i--) {
            // j 应该从左往右
            for (int j = i+1; j <=n+1 ; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i+1; k <j ; k++) {
                    // 择优做选择
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}

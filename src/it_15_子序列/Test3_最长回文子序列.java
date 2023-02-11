package it_15_子序列;

/**
 * 为了保证每次计算dp[i][j]，左、下、左下三个方向的位置已经被计算出来，只能斜着遍历或者反着遍历
 * 找到状态转移和 base case 之后，一定要观察 DP table，看看怎么遍历才能保证通过已计算出来的结果解决新的问题
 */
public class Test3_最长回文子序列 {
    public static void main(String[] args) {
        String s="abxabyb";
        int result=new Test3_最长回文子序列().longestPalindromeSubseq(s);
        System.out.println(result);

    }

    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j <n ; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

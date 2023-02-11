package it_16_编辑距离;

/**
 * dp 函数的 base case 是 i,j 等于 -1， ⽽数组索引⾄少是 0， 所以 dp 数组会
 * 偏移⼀位
 */
public class Test2_dpTable {
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "e";
        int result=new Test2_dpTable().minDistance(word1,word2);
        System.out.println(result);
    }
    public int minDistance(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        //base case:dp[..][0]和dp[0][..]
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j <=m; j++) {
            dp[0][j]=j;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                //i和j都是从1开始的
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[n][m];
    }
}

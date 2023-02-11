package it_15_子序列;

/**
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。
 * 目前给出的数据，仅仅会存在一个最长的公共子序列
 *
 * 难点在于需要倒推回去求每个点
 */

public class it_4_最长公共子序列_2 {
    public static void main(String[] args) {

    }

    public String LCS(String s1, String s2) {
        // write code here
        int s1Len = s1.length(), s2Len = s2.length();
//        int n=s1Len>s2Len?s1Len:s2Len;
        int[][] dp = new int[s1Len + 1][s2Len + 1];

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int i = s1Len, j = s2Len;
        while (i != 0 && j != 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res.append(s1.charAt(i - 1));
                i--;
                j--;
            } else{
                if (dp[i-1][j]>=dp[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
        return res.length()==0?"-1":res.reverse().toString();
    }
}

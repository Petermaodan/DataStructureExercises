package niuke;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 *
 * 输入：
 * "1AB2345CD","12345EF"
 * 返回值：
 * "2345"
 */
public class it_24_最长公共子串 {
    public static void main(String[] args) {
        String s1="1AB2345CD";
        String s2="12345EF";
        System.out.println(new it_24_最长公共子串().LCS(s1,s2));
    }

    //首先使用最长公共子序列的方式思考
    public String LCS (String str1, String str2) {
        // write code here
        int n=str1.length();
        int m=str2.length();
        //考虑到空白字符串，所以这里是n+1和m+1；
        int[][] dp=new int[n+1][m+1];
        int result=0;

        //index用来记录最长子串的下标
        int index=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    //且dp[i][j] 表示的是以A[i]，B[j]截尾的公共子串的长度,注意这里不包括i，是一个开区间，实际只截到i-1的位置
                    dp[i][j]=dp[i-1][j-1]+1;

                    if (result<dp[i][j]){
                        result=dp[i][j];
                        index=i;
                    }
                }
            }
        }
        return result==0?"-1":str1.substring(index-result,index);

    }
}

package leetcode.hot100;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 输出：true
 示例 2：

 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 输出：false

 ，本题也可以利用其思想求解：
 target 的每个字符都是从 s1（向下）或者 s2（向右）拿到的，所以只要判断是否存在这条 target 路径即可；

 于是可定义 boolean[][] dp ，dp[i][j] 代表 s1 前 i 个字符与 s2 前 j 个字符拼接成 s3 的 i+j 字符，也就是存在目标路径能够到达 i ,j ；
 状态方程：
 dp[i,j] = (dp[i-1][j] &&s3[i+j-1] == s1[i-1]) || (dp[i][j-1] && s3[i+j-1] == s2[j-1])

 */
public class it_97_交错字符串 {
    public static void main(String[] args) {
        String s1="";
        String s2="";
        String s3="a";
        boolean res = new it_97_交错字符串().isInterleave(s1, s2, s3);
        System.out.println(res);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length();
        if (s3.length()!=m+n)return false;
        boolean[][] dp= new boolean[m + 1][n + 1];

        //base case
        dp[0][0]=true;
        //边界
        for (int i = 1; i <=m&&s1.charAt(i-1)==s3.charAt(i-1) ; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i <=n&&s2.charAt(i-1)==s3.charAt(i-1) ; i++) {
            dp[0][i]=true;
        }

        //动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //i = 1, j = 1表示s1的第一个字符与s2的第一个字符，拼成了s3的前2个字符，也就是下标为1了
                //这里直接画一个图就可以理解了
                //所以这里就是i+j-1
                dp[i][j]=(dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1))||(dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }
        return dp[m][n];
    }
}

package leetcode.hot100;

import java.util.Arrays;

/**
 * 定义 f[i][j]f[i][j] 为考虑长度为 i + 1i+1 的字符串，且结尾元素为 jj 的方案数（其中 jj 代表数组 ['a', 'e', 'i', 'o', 'u'] 下标）。
 * <p>
 * <p>
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 * 为了方便大家理解，还是将常规的「从 f[i] 出发往前更新 f[i + 1]作为主要分析方法吧。
 * <p>
 * 根据条件可以容易写出转移方程：
 * <p>
 * 每个元音 'a' 后面都只能跟着 'e' ：f[i + 1][1] += f[i][0]；
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i' ：f[i + 1][0] += f[i][1]、f[i + 1][2] += f[i][1]；
 * 每个元音 'i' 后面 不能 再跟着另一个 'i' ：f[i + 1][j] += f[i][2], (j 不能为 2)；
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u' ：f[i + 1][2] += f[i][3]、f[i + 1][4] += f[i][3]；
 * 每个元音 'u' 后面只能跟着 'a' ：f[i + 1][0] += f[i][4]。
 */
public class it_1220_统计元音字母序列数目 {
    public static void main(String[] args) {
        int n = 144;
        int res = new it_1220_统计元音字母序列数目().countVowelPermutation(n);
        System.out.println(res);
    }

    public int countVowelPermutation(int n) {
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < n - 1; i++) {
            // 每个元音 'a' 后面都只能跟着 'e'
            dp[i + 1][1] += dp[i][0];
            // 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
            dp[i + 1][0] += dp[i][1];
            dp[i + 1][2] += dp[i][1];
            // 每个元音 'i' 后面 不能 再跟着另一个 'i'
            dp[i + 1][0] += dp[i][2];
            dp[i + 1][1] += dp[i][2];
            dp[i + 1][3] += dp[i][2];
            dp[i + 1][4] += dp[i][2];
            // 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
            dp[i + 1][2] += dp[i][3];
            dp[i + 1][4] += dp[i][3];
            // 每个元音 'u' 后面只能跟着 'a'
            dp[i + 1][0] += dp[i][4];


            for (int j = 0; j < 5; j++) dp[i + 1][j] %= MOD;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) ans += dp[n - 1][i];
        return (int) (ans % MOD);

    }
}

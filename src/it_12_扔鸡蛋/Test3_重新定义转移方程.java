package it_12_扔鸡蛋;

/**
 * 给你 K 鸡蛋， N 层楼， 让你求最坏情况下最少的测试次数 m
 * 吗？ while 循环结束的条件是 dp[K][m] == N ， 也就是给你 K 个鸡蛋，
 * 测试 m 次， 最坏情况下最多能测试 N 层楼
 */
public class Test3_重新定义转移方程 {
    public static void main(String[] args) {
        int result = new Test3_重新定义转移方程().superEggDrop(3, 14);
        System.out.println(result);
    }

    private int superEggDrop(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        //base case:
        //dp[0][...]=0
        //dp[..][0]=0
        int m = 0;
        while (dp[K][m]<N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }
}

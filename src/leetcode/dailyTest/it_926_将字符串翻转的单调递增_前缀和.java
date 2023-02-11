package leetcode.dailyTest;

/**
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 *
 * 举个例子，对于 S = "010110"： P = [0, 0, 1, 1, 2, 3, 3]。假设 x=3，即最终答案左边有三个 0。
 *
 * 有 P[3] = 1 个 1 在左边全 0 部分，P[6] - P[3] = 2 个 1 在右边全 1 部分。
 *
 * 所以，左边有 P[3] = 1 个 1 需要反转，右边有 (N-x) - (P[N] - P[x]) = 1 个 0 需要去反转。
 *

 */
public class it_926_将字符串翻转的单调递增_前缀和 {
    public static void main(String[] args) {
        String s = "010110";
        int res = new it_926_将字符串翻转的单调递增_前缀和().minFlipsMonoIncr(s);
        System.out.println(res);
    }
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int[] P=new int[n+1];
        //统计1的个数
        for (int i = 0; i <n; i++) {
            P[i+1]=P[i]+(s.charAt(i)=='1'?1:0);
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            res=Math.min(res,P[i]+(n-i)-(P[n]-P[i]));
        }
        return res;
    }
}

package jianzhioffer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class it_49_丑数 {
    public static void main(String[] args) {
        int n=10;
        int res = new it_49_丑数().nthUglyNumber(n);
        System.out.println(res);

    }

    public int nthUglyNumber(int n) {
        //三指针分别向后移动
        int a=0,b=0,c=0;
        int[] dp=new int[n];
        //base case
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            dp[i]=Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            //若存在相同的最小值，需要两个指针同时后移，避免重复
            if (dp[a]*2==dp[i])a++;
            if (dp[b]*3==dp[i])b++;
            if (dp[c]*5==dp[i])c++;
        }
        return dp[n-1];
    }
}

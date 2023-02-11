package leetcode.hot100;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 *
 * 思路
 */
public class it_372_超级次方_超级幂 {
    public static void main(String[] args) {
        int a=2147483647;
        int[] b = {2,0,0};
        int res = new it_372_超级次方_超级幂().superPow(a, b);
        System.out.println(res);
    }

    int mod=1337;
    public int superPow(int a, int[] b) {
         return dfs(a,b,b.length-1);
    }

    private int dfs(int a, int[] b, int idx) {
        if (idx==-1)return 1;
        //直接返回一个整体
        //这里使用超级幂求解
        return myPow(dfs(a,b,idx-1),10)*myPow(a,b[idx])%mod;
    }

    private int myPow(int a, int b) {
        int res=1;
        a=a%mod;
        while (b>0){
            if ((b&1)!=0){
                res=res*a%mod;
            }
            a=a*a%mod;
            b>>=1;
        }
        return res;
    }
}

package jianzhioffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段
 * （m、n都是整数，n>1并且m>1），每段绳子的长度记为
 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最
 * 大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 思路，总归是要剪成3才能创造最大值
 * 往3上靠，总共是三种可能刚好以及余1和余2，余1就要往前进一位
 */
public class it_14_1_剪绳子 {
    public static void main(String[] args) {
        int n=10;
        int res=new it_14_1_剪绳子().cuttingRope(n);
        System.out.println(res);
    }
    public int cuttingRope(int n) {
        if (n<=3)return n-1;
        int a=n/3,b=n%3;
        if (b==0)return (int) ((int) Math.pow(3,a)%(1e9+7));
        if (b==1)return (int) ((int) (Math.pow(3,a-1)*4)%(1e9+7));
        return (int) ((int) (Math.pow(3,a)*2)%(1e9+7));
    }

}

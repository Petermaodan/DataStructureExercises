package leetcode.hot100;

/**
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 *
 */
public class it_829_连续整数求和 {
    public static void main(String[] args) {
        int n=15;
        int res = new it_829_连续整数求和().consecutiveNumbersSum(n);
        System.out.println(res);
    }
    public int consecutiveNumbersSum(int n) {
        int res=0;
        n*=2;
        for (int k = 1; k*k < n; k++) {
            if (n%k!=0){
                continue;
            }
            if ((n/k-k+1)%2==0){
                res++;
            }
        }
        return res;
    }
}

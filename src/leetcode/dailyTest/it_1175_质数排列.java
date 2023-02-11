package leetcode.dailyTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。

 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 *
 * 先打表再求解，将100以内的质数先用list保存
 */
public class it_1175_质数排列 {
    public static void main(String[] args) {
        int n=100;
        int res = new it_1175_质数排列().numPrimeArrangements(n);
        System.out.println(res);
    }


    static List<Integer> list=new ArrayList<>();
    static int mod= (int) (1e9+7);
    static {
        for (int i = 2; i <= 100; i++) {
            boolean ok=true;
            for (int j = 2; j*j <= i; j++) {
                if (i%j==0){
                    ok=false;
                }

            }
            if (ok){
                list.add(i);
            }
        }
    }
    public int numPrimeArrangements(int n) {
        //二分法找有几个质数
        int l=0,r=list.size()-1;
//        while (l < r) {
//            int mid = l + r + 1 >> 1;
//            if (list.get(mid) <= n) l = mid;
//            else r = mid - 1;
//        }

        while (l<=r){
            int mid=(l+r)/2;
            if (list.get(mid)<n){
                l=mid+1;
            }else if (list.get(mid)==n){
                r=mid;
                break;
            }else {
                r=mid-1;
            }
        }
        int a=r+1,b=n-a;
        long ans=1;
        for (int i = b; i > 1; i--) {
            ans=ans*i%mod;
        }
        for (int i = a; i > 1; i--) {
            ans=ans*i%mod;
        }
        return (int)ans;
    }

}

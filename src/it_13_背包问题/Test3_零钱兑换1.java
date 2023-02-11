package it_13_背包问题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test3_零钱兑换1 {
    public static void main(String[] args) {
        int[] coins={1, 2, 5};
        int amount=11;
        int result1=new Test3_零钱兑换1().coinChange(coins,amount);
        int result2=new Test3_零钱兑换1().coinChange1(coins,amount);
        System.out.println(result1+" "+result2);
    }



    //通俗易懂的方法，暴力递归
//    int res=Integer.MAX_VALUE;
//    public  int coinChange1(int[] coins,int amount){
//        if (amount<0)return -1;
//        int count=0;
//        findCount(coins,amount,count);
//        if (res==Integer.MAX_VALUE){
//            return -1;
//        }
//        return res;
//    }
//
//    private  void findCount(int[] coins, int amount, int count) {
//        //跳出递归
//        if (amount<0)return;
//        if (amount==0){
//            res=Math.min(res,count);
//        }
//        for (int i = 0; i < coins.length; i++) {
//            findCount(coins,amount-coins[i],count+1);
//        }
//    }


    /**
     为啥 dp 数组初始化为 amount + 1 呢， 因为凑成 amount ⾦额的硬
     币数最多只可能等于 amount （全⽤ 1 元⾯值的硬币） ， 所以初始化为
     amount + 1 就相当于初始化为正⽆穷， 便于后续取最⼩值。
     */

    public static int coinChange1(int[] coins,int amount){
       int[] dp=new int[amount+1];
       Arrays.fill(dp,amount+1);
       //base case
        dp[0]=0;
        for (int coin : coins) {
            for (int i = 0; i <=amount; i++) {
                if (i>=coin){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }


    private static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        //base case:
        dp[0]=0;
        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]<0)continue;//continue跳出循环，特别关键
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);//两种选择，不找零--继承之前的结果、找零--+1
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}

package it_12_扔鸡蛋;
/**
 * 题目是这样：你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。
 * 现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎）。
 * 现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？
 */

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        int result=new Test1().superEggDrop(3,14);
        System.out.println(result);
    }
    Map<String,Integer> memo=new HashMap<>();
    public  int superEggDrop(int K,int N){

        return dp(K,N);
    }

    private  int dp(int k, int n) {
        //base case
        if (k==1)return n;//只有一个鸡蛋，最坏情况只能线性扫描
        if (n==0)return 0;//无鸡蛋，扔个锤子
        //避免重复计算
        if (memo.containsKey(k+":"+n)){
            return memo.get(k+":"+n);
        }
        int res=Integer.MAX_VALUE;
        for (int i = 1; i < n+1; i++) {
            res=Math.min(res,Math.max(dp(k,n-i),
                    dp(k-1,i-1))+1);
        }
        memo.put(k+":"+n,res);
        return res;
    }
}

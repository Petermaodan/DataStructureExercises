package it_12_扔鸡蛋;

import java.util.HashMap;
import java.util.Map;

public class Test2_二分优化 {
    public static void main(String[] args) {
        int result=new Test2_二分优化().superEggDrop(3,14);
        System.out.println(result);
    }
    int INFINITY=Integer.MAX_VALUE;
    Map<String,Integer> memo=new HashMap<>();
    public  int superEggDrop(int K,int N){

        return dp(K,N);
    }

    private int dp(int k, int n) {
        if (k==1)return n;//线性查找
        if (n==0)return 0;//不存在楼层
        if (memo.containsKey(k+":"+n)){
            return memo.get(k+":"+n);
        }
        int res=INFINITY;
        //用二分搜索代替线性搜索
        int lo=1,hi=n;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            int broken=dp(k-1,mid-1);//碎
            int not_broken=dp(k,n-mid);//没碎
            //res=min(max(碎，没碎)+1)
            if (broken>not_broken){
                hi=mid-1;
                res=Math.min(res,broken+1);
            }else {
                lo=mid+1;
                res=Math.min(res,not_broken+1);
            }
        }
        memo.put(k+":"+n,res);
        return res;
    }
}

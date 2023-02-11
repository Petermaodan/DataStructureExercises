package leetcode.dailyTest;

import java.util.Arrays;

/**
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 */
public class it_473_火柴拼正方形_回溯 {
    public static void main(String[] args) {
        int[] matchsticks = {1,1,2,2,2};
        boolean res = new it_473_火柴拼正方形_回溯().makesquare(matchsticks);
        System.out.println(res);
    }
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum+=matchstick;
        }
        if (sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0,j=matchsticks.length-1; i < j; i++,j--) {
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[j];
            matchsticks[j]=temp;
        }
        int[] edges=new int[4];
        return dfs(0,matchsticks,edges,sum/4);
    }

    private boolean dfs(int idx, int[] matchsticks, int[] edges, int len) {
        //跳出递归
        if (idx==matchsticks.length){
            return true;
        }
        for (int i = 0; i < 4; i++) {
            edges[i]+=matchsticks[idx];
            if (edges[i]<=len&&dfs(idx+1,matchsticks,edges,len)){
                return true;
            }
            edges[i]-=matchsticks[idx];
        }
        return false;
    }
}

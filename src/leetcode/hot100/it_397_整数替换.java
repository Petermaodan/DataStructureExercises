package leetcode.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 */
public class it_397_整数替换 {
    public static void main(String[] args) {
        int n=7;
        int res = new it_397_整数替换().integerReplacement(n);
        System.out.println(res);
    }


    //bfs
    private int integerReplacement(int n) {
        if (n==1)return 0;
        Queue<Long> queue=new LinkedList<>();
        Map<Long,Integer> map=new HashMap<>();
        map.put(n*1L,0);
        queue.add(n*1L);
        while (!queue.isEmpty()){
            Long temp=queue.poll();
            int step=map.get(temp);
            Long[] ns=temp%2==0?new Long[]{temp/2}:new Long[]{temp+1,temp-1};
            for (Long l : ns) {
                if (l==1)return step+1;
                if (!map.containsKey(l)){
                    map.put(l,step+1);
                    queue.add(l);
                }
            }
        }
        return -1;
    }



    //使用递归求解，dfs方法
    Map<Long,Integer> map=new HashMap<>();
    private int integerReplacement3(int n) {
        return dfs(n*1L);
    }

    private int dfs(long n) {
        if (n==1)return 0;
        if (map.containsKey(n))return map.get(n);
        int ans=n%2==0?dfs(n/2):Math.min(dfs(n+1),dfs(n-1));
        ans++;
        map.put(n,ans);
        return ans;
    }

    //错误解法
    public int integerReplacement2(int n) {
        int res=0;
        while (n>1){
            if ((n%2)==1){
                n-=1;
            }else {
                n/=2;
            }
            res++;

        }
        return res;
    }
}

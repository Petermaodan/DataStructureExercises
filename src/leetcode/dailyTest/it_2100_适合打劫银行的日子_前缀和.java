package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 *
 * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：security = [5,3,3,3,5,6,2], time = 2
 * 输出：[2,3]
 * 解释：
 * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
 * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
 * 没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
 *

 */
public class it_2100_适合打劫银行的日子_前缀和 {
    public static void main(String[] args) {
        int[] security = {5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> list = new it_2100_适合打劫银行的日子_前缀和().goodDaysToRobBank(security, time);
        ListUtil.arrayOne(list);
    }
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //初始化g[],g[i]代表security[i]是否比security[i-1]大
        int n=security.length;
        int[] g=new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i]==security[i-1]){
                continue;
            }
            g[i]=security[i]>security[i-1]?1:-1;
        }
        int[] a=new int[n+1],b=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            a[i]=a[i-1]+(g[i-1]==1?1:0);
        }
        for (int i = 1; i <=n ; i++) {
            b[i]=b[i-1]+(g[i-1]==-1?-1:0);
        }
        //统计前缀和1和-1的数量
        List<Integer> res=new ArrayList<>();
        for (int i = time; i <n-time ; i++) {
            int count1=a[i+1]-a[i+1-time],count2=b[i+1]-b[i+1+time];
            if (count1==0&&count2==0){
                res.add(i);
            }
        }
        return res;
    }
}

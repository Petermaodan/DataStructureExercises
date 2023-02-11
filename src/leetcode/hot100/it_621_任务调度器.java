package leetcode.hot100;

import java.util.Arrays;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间

 */
public class it_621_任务调度器 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int res=new it_621_任务调度器().leastInterval(tasks,n);
        System.out.println(res);
    }

    public int leastInterval(char[] tasks,int n){
        int len=tasks.length;
        int[] vec=new int[26];
        int maxValue=Integer.MIN_VALUE;
        for (int c : tasks) {
            //统计相同任务的数量
            ++vec[c-'A'];
            maxValue=Math.max(maxValue,vec[c-'A']);
        }
        //统计最后一个桶的任务数
        int cnt=0;
        for (int i = 0; i < 26; i++) {
        if (vec[i]==maxValue){
            cnt++;
        }
    }

    //当有空闲时间时，排队时间=（桶个数-1）*（n+）+最后一个桶的任务数
    //当不存在空闲时间时，排队时间=总的任务数
        return Math.max(len,cnt+(n+1)*(vec[0]-1));
}
}

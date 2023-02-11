package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1
 *
 */
public class it_997_找到小镇的法官 {
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int res=new it_997_找到小镇的法官().findJudge(4,trust);
        System.out.println(res);
    }

    //优化->入度和出度的简单模拟
    private int findJudge(int n , int[][] trust) {
        int[] in=new int[n+1],out=new int[n+1];
        for (int[] ints : trust) {
            int a=ints[0],b=ints[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i]==n-1&&out[i]==0)return i;
        }
        return -1;

    }

    public int findJudge2(int n, int[][] trust) {
        int[] dic=new int[n+1];
        int len=trust.length;
        Set<Integer> set=new HashSet<>();
        int fg=-1;
        for (int i = 0; i < len; i++) {
            set.add(trust[i][0]);
            dic[trust[i][1]]++;
            if (dic[trust[i][1]]==n-1){
                fg=trust[i][1];
            }
        }
        return set.contains(fg)?-1:fg;

    }
}

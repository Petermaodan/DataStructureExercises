package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 */
public class it_71_按权重生成随机数 {
    public static void main(String[] args) {
        new it_71_按权重生成随机数().test();
    }
    public void test(){
        int[] nums={1,3};
        Solution solution=new Solution(nums);
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    class Solution {
        int[][] map;
        Random random;
        int sum;
        public Solution(int[] w) {
            int n=w.length;
            map=new int[n][3];
            random=new Random();
            sum=0;
            for (int i = 0; i < n; i++) {
                map[i][0]=sum;
                map[i][1]=sum+w[i];
                map[i][2]=i;
                sum+=w[i];
            }
        }

        public int pickIndex() {
            int idx=random.nextInt(sum);
            for (int[] ints : map) {
                if (idx>=ints[0]&&idx<ints[1]){
                    return ints[2];
                }
            }
            return 0;
        }
    }
}

package leetcode.hot100;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 *
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 *
 * 实现 Solution 类：
 *
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 *
 * 思路：
 * 矩阵大小的数据范围为 10^4
 *  ，因此我们不能使用真实构建矩阵的做法来做，同时利用二维的坐标能够唯一对应出编号（idx = row * n + col），可以将问题转换为一维问题。
 *
 * 一个比较取巧的做法是：利用调用次数只有 10^3
 *  ，我们可以在 [0, m * n） 范围内随机出一个下标 idx（对应矩阵的某个具体位置），然后从 idx 往两边进行扫描，找到最近一个未被使用的位置，将其进行标记翻转并返回。
 */
public class it_519_随机翻转矩阵 {
    class Solution {
        Set<Integer> set=new HashSet<>();
        Random random=new Random();
        int m,n;
        public Solution(int m, int n) {
            this.m=m;
            this.n=n;
        }

        public int[] flip() {
            //将二维矩阵转化为一维求解
            //这里能保证期望值是相同的
            int a=random.nextInt(m*n),b=a;
            while (a>=0&&set.contains(a))a--;
            while (b<m*n&&set.contains(b))b++;
            int c=a>=0&&!set.contains(a)?a:b;
            //通过整除和取余求row和col
            //（idx = row * n + col）
            set.add(c);
            return new int[]{c/n,c%n};
        }

        public void reset() {
            set.clear();
        }
    }
}

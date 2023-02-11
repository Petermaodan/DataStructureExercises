package leetcode.dailyTest;

import java.util.Random;

/**
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 *
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 *
 * 请注意 ，整数点是具有整数坐标的点。
 *
 * 实现 Solution 类:
 *
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 */
public class it_497_非重叠矩形中的随机点_前缀和_二分 {

    class Solution {

        int[] sum;
        Random random;
        int n;
        int[][] rects;
        public Solution(int[][] rects) {
            n=rects.length;
            sum=new int[n+1];
            random=new Random();
            this.rects=rects;
            for (int i = 1; i <= n; i++) {
                //理解成点数就可以了，计算的是矩形里的总点数,所以这里需要＋1
                sum[i]=sum[i-1]+(rects[i-1][2]-rects[i-1][0]+1)*(rects[i-1][3]-rects[i-1][1]+1);
            }
        }

        public int[] pick() {
            int val=random.nextInt(sum[n]+1);
            int l=1,r=n;
            while (l<r){
                int mid=(l+r)/2;
                if (sum[mid]>=val){
                    r=mid;
                }else {
                    l=mid+1;
                }
            }
            l--;
            //找到所对应的矩形
            int x=random.nextInt((rects[l][2]-rects[l][0]+1))+rects[l][0];
            int y=random.nextInt((rects[l][3]-rects[l][1]+1))+rects[l][1];
            return new int[]{x,y};
        }
    }
}

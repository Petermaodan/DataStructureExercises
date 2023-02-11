package leetcode.dailyTest;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 *
 * 由于存在「吃完这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉」的条件，因此不会存在多堆香蕉共用一个小时的情况，即每堆香蕉都是相互独立，同时可以明确每堆香蕉的耗时为 \left \lceil \frac{piles[i]}{k} \right \rceil⌈kpiles[i]
（其中 k 为速度）。
 *
 * 因此我们可以二分 kk 值，在以 k 为分割点的数组上具有「二段性」：
 *
 * 小于 kk 的值，总耗时 ans必然不满足 hans≤h；
 * 大于等于 kk 的值，总耗时 ans 必然满足hans≤h
 *
 */
public class it_875_爱吃香蕉的_二分法应用 {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        int res = new it_875_爱吃香蕉的_二分法应用().minEatingSpeed(piles, h);
        System.out.println(res);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l=0,r= (int) 1e9;
        while (l<r){
            int mid=(l+r)/2;
            if (check(piles,mid,h)){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }

    private boolean check(int[] piles, int mid, int h) {
        int res=0;
        for (int pile : piles) {
            //向上取整
            res+=Math.ceil(pile*1.0/mid);
        }
        return res<=h;
    }
}

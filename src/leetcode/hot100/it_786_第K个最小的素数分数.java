package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.PriorityQueue;

/**
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 *  
 * 示例 1：
 *
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 *
 * 思路：比较单纯的想法就是构造一个堆来实现即可
 */
public class it_786_第K个最小的素数分数 {
    public static void main(String[] args) {
        int[] nums={1,2,3,5};
        int k=3;
        int[] ints = new it_786_第K个最小的素数分数().kthSmallestPrimeFraction(nums, k);
        ListUtil.arrayOneNums(ints);

    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> Double.compare((o2[0]*1.0/o2[1]),(o1[0]*1.0/o1[1])));

        //遍历每一种情况
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                double temp=arr[i]*1.0/arr[j];
                if (queue.size()<k||queue.peek()[0]*1.0/queue.peek()[1]>temp){
                    if (queue.size()==k)queue.poll();
                    queue.add(new int[]{arr[i],arr[j]});
                }
            }
        }
        return queue.poll();
    }
}

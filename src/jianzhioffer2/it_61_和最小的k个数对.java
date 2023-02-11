package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
*
 * 小根堆实现
 */
public class it_61_和最小的k个数对 {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> res = new it_61_和最小的k个数对().kSmallestPairs(nums1, nums2, k);
        ListUtil.arrayTwo(res);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m=nums1.length,n=nums2.length;
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]]);
        //先将nums1的组合加入优先队列
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.add(new int[]{i,0});
        }
        List<List<Integer>> res=new ArrayList<>();
        while (k>0&&!queue.isEmpty()){
            int[] poll = queue.poll();
            List<Integer> list=new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            res.add(list);
            if (poll[1]<n-1){
                //将nums2下标往后移一位
                queue.add(new int[]{poll[0],poll[1]+1});
            }
            k--;
        }
        return res;
    }
}

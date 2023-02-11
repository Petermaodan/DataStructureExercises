package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */
public class it_373_查找和最小的K对数字 {
    public static void main(String[] args) {
        int[] nums1={1,7,11};
        int[] nums2={2,4,6};
        List<List<Integer>> lists = new it_373_查找和最小的K对数字().kSmallestPairs(nums1, nums2, 3);
        ListUtil.arrayTwo(lists);

    }


    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m=nums1.length,n=nums2.length;
        //设置下标为索引的优先队列
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]]);
        List<List<Integer>> res=new ArrayList<>();
        //  的索引增加即可，这样避免了重复加入元素的问题
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.add(new int[]{i,0});
        }
        //遍历nums2寻找合适的值
        while (k>0&&!queue.isEmpty()){
            //弹出队列中最小值的下标
            int[] poll = queue.poll();
            List<Integer> temp=new ArrayList<>();
            temp.add(nums1[poll[0]]);
            temp.add(nums2[poll[1]]);
            res.add(temp);
            //加入新的下标
            if (poll[1]<n-1){
                queue.add(new int[]{poll[0],poll[1]+1});
            }
            k--;
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        int i=0,j=0;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> firstList=new ArrayList<>();
        firstList.add(nums1[i]);
        firstList.add(nums2[j]);
        res.add(firstList);
        while (k>1){
            List<Integer> temp=new ArrayList<>();
            if (i<nums1.length-1&&j<nums2.length-1){
                if (nums1[i]+nums2[j+1]<nums2[j]+nums1[i+1]){
                    temp.add(nums1[i]);
                    temp.add(nums2[++j]);
                }else {
                    temp.add(nums1[++i]);
                    temp.add(nums2[j]);
                }
                k--;
                res.add(temp);
                continue;
            }
            if (i==nums1.length-1){
                temp.add(nums1[i]);
                temp.add(nums2[++j]);
                res.add(temp);
                k--;
            }else {
                temp.add(nums1[++i]);
                temp.add(nums2[j]);
                res.add(temp);
                k--;
            }
        }
        return res;
    }
}

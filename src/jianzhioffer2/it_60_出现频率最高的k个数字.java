package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 */
public class it_60_出现频率最高的k个数字 {
    public static void main(String[] args) {
        int[] nums={5,3,1,1,1,3,73,1};
        int k=2;
        int[] res = new it_60_出现频率最高的k个数字().topKFrequent(nums, k);
        ListUtil.arrayOneNums(res);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> queue=new PriorityQueue((o1, o2) -> {
            return map.get(o1)-map.get(o2);
        });
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer key : map.keySet()) {
            if (queue.size()<k){
                queue.add(key);
            }else if (map.get(key)>map.get(queue.peek())){
                queue.poll();
                queue.add(key);
            }
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll();
        }
        return res;
    }
}

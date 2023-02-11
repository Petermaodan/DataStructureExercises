package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class it_347_前k个高频元素 {
    public static void main(String[] args) {
        int[] nums={3,0,1,0};
        int[] res=new it_347_前k个高频元素().topKFrequent2(nums,1);
        ListUtil.arrayOneNums(res);

    }

    //堆排序
    public  int[] topKFrequent2(int[] nums, int k){
        int[] res=new int[k];
        Map<Integer,Integer> countNums=new HashMap<>();
        for (int num : nums) {
            countNums.put(num,countNums.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countNums.get(o1)-countNums.get(o2);
            }
        });

        for (Integer key : countNums.keySet()) {
            if (pq.size()<k){
                pq.add(key);
            }else if (countNums.get(key)>countNums.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        //导出结果
        for (int i = 0; i < k; i++) {
            res[i]=pq.remove();
        }
        return res;

    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer,Integer> countNums=new HashMap<>();
        int maxTimes=0;
        for (int num : nums) {
            countNums.put(num,countNums.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : countNums.entrySet()) {
            if (entry.getValue()>maxTimes){
                maxTimes=entry.getValue();
            }
        }

        //从多到少放入数组
        while (k>0){
            for (Map.Entry<Integer, Integer> entry : countNums.entrySet()) {
                if (entry.getValue()==maxTimes){
                    res[k-1]=entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }
        return res;

    }
}

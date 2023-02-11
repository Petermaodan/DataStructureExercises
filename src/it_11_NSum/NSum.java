package it_11_NSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 将之前的写法进行总结，实际上就是一个递归
 */
public class NSum {
    public static void main(String[] args) {

    }

    //调用这个函数之前，要先对nums进行排序
    public List<List<Integer>> nSumTarget(int[] nums,int n,int start,int target){
        int size=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        //跳出递归的条件
        if (n<2||size<n){
            return res;
        }
        if (n==2){
            //双指针那一套
            int lo=start,hi=size-1;
            while (lo<hi){
                int sum=nums[lo]+nums[hi];
                int left=nums[lo],right=nums[hi];
                if (sum<target){
                    while (lo<hi&&nums[lo]==left)lo++;
                }else if (sum>target){
                    while (lo<hi&&nums[hi]==right)hi--;
                }else {
                    List<Integer> list=new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (lo<hi&&nums[lo]==left)lo++;
                    while (lo<hi&&nums[hi]==right)hi--;
                }
            }
        }else {
            for (int i = start; i < size; i++) {
                List<List<Integer>> tuples=nSumTarget(nums,n-1,i+1,target-nums[i]);
                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                while (i<size-1&&nums[i]==nums[i+1])i++;
            }
        }
        return res;
    }
}

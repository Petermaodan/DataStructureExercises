package niuke;

import BaseUtil.ListUtil;

import java.util.HashMap;
import java.util.Map;

public class it_9_两数之和 {
    public static void main(String[] args) {
        int[] nums= {3,2,4};
        int target= 6;
        int[] res=new it_9_两数之和().twoSum(nums,target);
        ListUtil.arrayOneNums(res);


    }
    //用哈希表储存
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i],i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int other=target-numbers[i];
            if (hashMap.containsKey(other)&&hashMap.get(other)!=i){
                return new int[]{i+1,hashMap.get(other)+1};
            }
        }
        return new int[]{-1,-1};
    }
}

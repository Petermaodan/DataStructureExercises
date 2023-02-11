package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class it_448_找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        ListUtil.arrayOne(new it_448_找到所有数组中消失的数字().findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        for (int num : nums) {
            nums[(num-1)%n]+=n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]<=n){
                res.add(i+1);
            }
        }

        return res;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> hashMap=new HashMap<>();
        int maxN=Integer.MIN_VALUE;
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
//            maxN=maxN<num?num:maxN;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (hashMap.getOrDefault(i,0)==0){
                res.add(i);
            }
        }
        return res;
    }
}

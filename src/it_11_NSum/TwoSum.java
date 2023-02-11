package it_11_NSum;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums={3,2,4};
        int target=6;
        int[] result=twoSumTarget2(nums,target);
        for (int i : result) {
            System.out.println(i);
        }
//
//        int[] nums2={1,1,1,2,2,3,3};
//        int target2=4;
//        List<List<Integer>> result2=twoSumTarget(nums2,target2);
//        for (List<Integer> list : result2) {
//            for (Integer integer : list) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }


    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> index=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other=target-nums[i];
            if (index.containsKey(other)&&index.get(other)!=i){
                return new int[]{i,index.get(other)};
            }
        }
        return new int[]{-1,-1};

    }

    private static int[] twoSumTarget2(int[] num,int target){
        Arrays.sort(num);
        int lo=0,hi=num.length-1;
        int[] res=new int[2];
        while (lo<hi){
            int sum=num[lo]+num[hi];
            if (sum<target){
                lo++;
            }else if (sum>target){
                hi--;
            }else {
                res[0]=lo;
                res[1]=hi;
                lo++;
                hi--;
            }
        }
        return res;
    }

    //左右指针法--->需要对数组现进行排序
    private static List<List<Integer>> twoSumTarget(int[] nums,int target){
        int n=nums.length;
        Arrays.sort(nums);
        int lo=0,hi=n-1;
        List<List<Integer>> ans=new ArrayList<>();
        while (lo<hi){
            int sum=nums[lo]+nums[hi];
            int left=nums[lo],right=nums[hi];
            if (sum<target){
                while (lo<hi&&nums[lo]==left){ //去除左边相同的数
                    lo++;
                }
            }else if (sum>target){
                while (lo<hi&&nums[hi]==right){//去除右边相同的数
                    hi--;
                }
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(left);
                list.add(right);
                ans.add(list);
                while (lo<hi&&nums[lo]==left){ //去除左边相同的数
                    lo++;
                }
                while (lo<hi&&nums[hi]==right){//去除右边相同的数
                    hi--;
                }
            }
        }
        return ans;
    }
}

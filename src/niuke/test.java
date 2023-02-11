package niuke;

import BaseUtil.ListUtil;

import java.util.*;

public class test{

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
//        List<List<Integer>> result =new test().threeSum(nums, target);
//        for (List<Integer> res : result) {
//            for (Integer re : res) {
//                System.out.print(re+" ");
//            }
//            System.out.println();
//        }
        int[] nums2={1,8,6,2,5,4,8,3,7};
//        int res=new test().maxArea(nums2);

        String s="cbaebabacd";
        String p="abc";
        List<Integer> res=new test().findAnagrams(s,p);
        ListUtil.arrayOne(res);

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        int valid=0;
        int pLen=p.length();
        for (int i = 0; i < pLen; i++) {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }
        int left=0,right=0;
        while (right<s.length()){
            char c=s.charAt(right);
            //right这里就先加过1了，如果是其他类型的题目要注意了
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (need.getOrDefault(c,0).equals(window.getOrDefault(c,-1))){
                    valid++;
                }

            }

            //判断是否需要收缩
            while (right-left>=pLen){
                if (need.size()==valid){
                    res.add(left);
                }
                char d=s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.getOrDefault(d,0).equals(window.getOrDefault(d,-1))){
                        valid--;
                    }
                    //将window中的d删除
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return res;
    }

    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        while (left<right){
            if (height[left]<=height[right]){
                res=Math.max(res,(right-left)*height[left]);
                left++;
            }else {
                res=Math.max(res,(right-left)*height[right]);
                right--;
            }
        }
        return res;
    }



    public  List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> threeList=twoSum(nums,i+1,target-nums[i]);
            for (List<Integer> list : threeList) {
                list.add(nums[i]);
                res.add(list);
            }
            while (i<nums.length-1&&nums[i]==nums[1+1]){
                i++;
            }
        }
        return res;

    }

    public  List<List<Integer>> twoSum(int[] nums,int start,int target){
        Arrays.sort(nums);
        List<List<Integer>> twoList=new ArrayList<>();
        int left=start,right=nums.length-1;
        while (left<right){
            int other=nums[left]+nums[right];
            int lo=nums[left],hi=nums[right];
            if (other>target){
                while (left<right&&nums[right]==hi){
                    right--;
                }
            } else if (other<target) {
                while (left<right&&nums[left]==lo){
                    left++;
                }
            }else {
                List<Integer> ans=new ArrayList<>();
                ans.add(nums[left]);
                ans.add(nums[right]);
                twoList.add(ans);
                while (left<right&&nums[right]==hi){
                    right--;
                }
                while (left<right&&nums[left]==lo){
                    left++;
                }
            }
        }
        return twoList;
    }

}
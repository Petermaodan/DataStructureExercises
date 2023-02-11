package jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class it_39_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2={2,2,1,1,1,2,2};
        int res = new it_39_数组中出现次数超过一半的数字().majorityElement(nums);
        System.out.println(res);
    }


    //摩尔投票法，如果是众数，就加一，否则减一
    public int majorityElement1(int[] nums) {
        int votes=0,x=0;
        int count=0;
        for(int num:nums){
            if (votes==0)x=num;
            votes+=num==x?1:-1;
        }
        for (int num:nums){
            if (x==num){
                count++;
            }
        }
        return count>nums.length/2?x:0;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }

}

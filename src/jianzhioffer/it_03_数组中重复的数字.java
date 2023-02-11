package jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class it_03_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(new it_03_数组中重复的数字().findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        int[] res=new int[nums.length];
        for (int num : nums) {
            res[num]++;
            if (res[num]>1)return num;
        }
        return -1;


    }

//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)){
//                return num;
//            }else {
//                set.add(num);
//            }
//        }
//        return -1;
//
//    }
}

package jianzhioffer;

import BaseUtil.ListUtil;

public class it_21_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        ListUtil.arrayOneNums(new it_21_调整数组顺序使奇数位于偶数前面().exchange2(nums));
    }

    //方法二，在原数组上操作，不需要开辟新的空间,实际上是基于快排的思想

    public int[] exchange(int[] nums) {
        if (nums.length==0)return nums;
        int l=0,r=nums.length-1;
        int temp=nums[l];
        while (l<r){
            while (l<r&&nums[r]%2==0){
                r--;
            }
            nums[l]=nums[r];
            while (l<r&&nums[l]%2==1){
                l++;
            }
            nums[r]=nums[l];
        }
        nums[l]=temp;
        return nums;
    }


    public int[] exchange2(int[] nums) {
        //首尾双指针
        int i=0,j=nums.length-1;
        while (i<j){
            if ((nums[i]&1)==1){
                i++;
                continue;
            }
            if ((nums[j]&1)==0){
                j--;
                continue;
            }
            swap(nums,i++,j--);
        }
        return nums;
    }

    private void swap(int[] nums,int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

//    public int[] exchange(int[] nums) {
//        int[] res=new int[nums.length];
//        int i=0,j=nums.length-1;
//        for (int k = 0; k < nums.length; k++) {
//            if ((nums[k]&1)==1){
//                res[i++]=nums[k];
//            }else {
//                res[j--]=nums[k];
//            }
//        }
//        return res;
//    }
}

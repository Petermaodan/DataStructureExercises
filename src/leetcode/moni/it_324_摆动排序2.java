package leetcode.moni;

import BaseUtil.ListUtil;

import java.util.Arrays;

/**
 * 1）首先对无序数组进行排序，使用额外的空间tmp
 * 2）排序之后，进行取数，从中间分成左右两部分，分别从两部分的末尾开始取
 * 3）这样的时间复杂度是n*logn，空间复杂度是n
 */
public class it_324_摆动排序2 {
    public static void main(String[] args) {
        int[] nums={1,1,1,4,5,6};
        new it_324_摆动排序2().wiggleSort(nums);
        ListUtil.arrayOneNums(nums);
     }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] ans=nums;
        //如果是奇数，那么中间的数属于前半部分
        int m=(n+1)/2,t=n;
        for (int i = 0; i < n; i++) {
            nums[i]=i%2==0?ans[--m]:ans[--t];
        }
    }
}

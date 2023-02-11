package it_08_滑动窗口;

/**
 * 给定一个正整数数组 nums和整数 k 。
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。

 */
public class it_713_乘积小于k的子数组 {
    public static void main(String[] args) {
        int[] nums={10,5,2,6};
        int res=new it_713_乘积小于k的子数组().numSubarrayProductLessThanK(nums,100);
        System.out.println(res);

    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        双指针法：？？？
        //ans=right-left+1;//固定住右边
        if (k<=0)return 0;
        int left=0;
        int prod=1;
        int ans=0;
        for (int right = 0; right < nums.length; right++) {
            prod*=nums[right];
            //若超过，就移动左区间
            while (prod>=k)prod/=nums[left++];
            ans+=right-left+1;
        }
        return ans;





        //暴力法：时间复杂度为O（n2）
//        int n=nums.length;
//        int i=0;
//        int res=0;
//        for (int l = 0; l < n; l++) {
//            int temp=nums[l];
//            i=l;
//            while (temp<k&&i<n){
//                res++;
//                if (i+1==n)break;
//                temp*=nums[++i];
//            }
//        }
//        return res;

    }
}

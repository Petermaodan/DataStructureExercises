package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums ,
 * 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class it_11_0和1个数相同的子数组 {
    public static void main(String[] args) {
        int[] nums={0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0};
        int res = new it_11_0和1个数相同的子数组().findMaxLength(nums);
        System.out.println(res);
    }

    //将数组中的0换成-1， 求和为0的最长子数组 转换成前缀和问题
    private int findMaxLength(int[] nums) {
        int res=0;
        int preSum=0;
        //替换0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                nums[i]=-1;
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        //初始值,前缀和一般都要设置
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            if (map.containsKey(preSum)){
                res=Math.max(res,i-map.get(preSum));
            }else {
                map.put(preSum,i);
            }
        }
        return res;
    }

    //不能解决
    public int findMaxLength2(int[] nums) {
        int l=0,r=0;
        int res=0;
        while (r<nums.length){
            int temp=r-l;
            while ((r<nums.length)&&((temp%2==0&&nums[l]==nums[r])||(temp%2==1&&nums[l]!=nums[r]))){
                r++;
                temp++;
            }
            res=Math.max(res,temp);
            l=r;
        }
        return res%2==0?res:res-1;
    }
}

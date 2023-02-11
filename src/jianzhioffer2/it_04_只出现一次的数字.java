package jianzhioffer2;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *
 * 思路： 位运算降低复杂度
 * 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1
 */
public class it_04_只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,100};
        int res = new it_04_只出现一次的数字().singleNumber(nums);
        System.out.println(res);
    }

    public int singleNumber(int[] nums) {
        int res=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            int sum=0;
            for (int num : nums) {
                if ((num>>i&1)!=0){
                    sum++;
                }
            }
            bits[i]=sum;
        }
        for (int i = 0; i < 32; i++) {
            if (bits[i]%3!=0){
                res+=1<<i;
            }
        }
        return res;
    }
}

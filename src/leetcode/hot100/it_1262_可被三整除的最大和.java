package leetcode.hot100;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和
 */
public class it_1262_可被三整除的最大和 {
    public static void main(String[] args) {
        int [] nums={3,6,5,1,8};
        int res=new it_1262_可被三整除的最大和().maxSumDixThree(nums);
        System.out.println(res);
    }

    public int maxSumDixThree(int[] nums){
        int N=nums.length;
        int[] remainder=new int[3];
        for (int i = 0; i < N; i++) {
            int a,b,c;
            a=remainder[0]+nums[i];
            b=remainder[1]+nums[i];
            c=remainder[2]+nums[i];
            remainder[a%3]=Math.max(remainder[a%3],a);
            remainder[b%3]=Math.max(remainder[b%3],b);
            remainder[c%3]=Math.max(remainder[c%3],c);
        }
        return remainder[0];
    }

}

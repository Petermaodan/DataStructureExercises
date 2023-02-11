package it_05_回溯;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2=new Test2();

        int[] nums={1,1,1,1,1};
        int target=3;

        int result1=test2.findTargetSumWays(nums,target);
        System.out.println(result1);
    }

    int result=0;
    private int findTargetSumWays(int[] nums,int rest){
        if (nums.length==0){
            return 0;
        }
        backtrack(0,nums,rest);
        return result;
    }

    private void backtrack(int i, int[] nums, int rest) {
        if (nums.length==i){
            if (rest==0){
                result++;
            }return;
        }

        rest+=nums[i];
        backtrack(i+1,nums,rest);
        rest-=nums[i];

        rest-=nums[i];
        backtrack(i+1,nums,rest);
        rest+=nums[i];
    }
}

package leetcode.hot100;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 *
 * 二分查找中，寻找 \textit{leftIdx}leftIdx 即为在数组中寻找第一个大于等于 \textit{target}target 的下标，
 * 寻找 \textit{rightIdx}rightIdx 即为在数组中寻找第一个大于 \textit{target}target 的下标，然后将下标减一。
 * 两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower) 表示在 \textit{nums}nums 数组中
 * 二分查找 \textit{target}target 的位置，如果 \textit{lower}lower 为 \rm truetrue，则查找第一个大于等于 \textit{target}target 的下标，
 * 否则查找第一个大于 \textit{target}target 的下标
 *

 *
 */
public class it_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums={};
        int target = 8;
        int[] res=new it_34_在排序数组中查找元素的第一个和最后一个位置().searchRange(nums,target);
        for (int re : res) {
            System.out.print(re+" ");
        }


    }
    public int[] searchRange(int[] nums, int target) {

        int leftIdx=binarySearch(nums,target,true);
        //找右边界的时候会多往前走一格
        int rightIdx=binarySearch(nums,target,false)-1;
        if (leftIdx<=rightIdx&&rightIdx<nums.length&&nums[leftIdx]==target&&nums[rightIdx]==target){
            return new int[]{leftIdx,rightIdx};
        }
        return new int[]{-1,-1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left=0,right=nums.length-1,ans=nums.length;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>target||(lower&&nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}

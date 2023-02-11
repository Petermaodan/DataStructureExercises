package leetcode.hot100;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 难点在时间复杂度
 * 因此如果不考虑“特殊”的单一元素的话，我们有结论：成对元素中的第一个所对应的下标必然是偶数，成对元素中的第二个所对应的下标必然是奇数
 *
 * 可以根据mid的奇偶性分开讨论
 */
public class it_540_有序数组中的单一元素 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int res = new it_540_有序数组中的单一元素().singleNonDuplicate(nums);
        System.out.println(res);
    }
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(l+r)/2;
            //若下标为偶数，则和后一个比较
            if (mid%2==0){
                if (mid+1<n&&nums[mid]==nums[mid+1]){
                    l=mid+1;
                }else {
                    r=mid;
                }
            }else {
                if (mid-1>=0&&nums[mid-1]==nums[mid]){
                    l=mid+1;
                }else {
                    r=mid;
                }
            }
        }
        return nums[r];
    }
}

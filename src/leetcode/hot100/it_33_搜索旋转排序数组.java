package leetcode.hot100;

/**
 * 有序数组首先想到的就是用二分法解决
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [\textit{nums}[l],\textit{nums}[mid])[nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
 * 如果 [mid, r] 是有序数组，且 target 的大小满足 (\textit{nums}[mid+1],\textit{nums}[r]](nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找
 *
 *
 */
public class it_33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target = 0;
        int res=new it_33_搜索旋转排序数组().search(nums,target);
        System.out.println(res);

    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        if (n==0)return -1;
        if (n==1)return nums[0]==target?0:-1;

        int l=0,r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[l]<=nums[mid]){//左边有序
                if (nums[l]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }

            else {//右边有序
                if (nums[mid]<target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;

    }
}

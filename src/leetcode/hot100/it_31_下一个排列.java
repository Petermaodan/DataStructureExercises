package leetcode.hot100;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间
处。

 标准的“下一个排列”算法可以描述为：

 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 将 A[i] 与 A[k] 交换
 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4

 */
public class it_31_下一个排列 {
    public static void main(String[] args) {
        int[] nums={1,2,3,8,5,7,6,4};
        new it_31_下一个排列().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }


    }
    public void nextPermutation(int[] nums){
        int n=nums.length;
        if (n<=1){
            return;
        }

        int i=n-2,j=n-1,k=n-1;
        //find :A[i]<A[j]
        while (i>=0&&nums[i]>=nums[j]){
            i--;
            j--;
        }
        if (i>=0){
            //不是最后最大的排列
            //find:A[i]<A[k]
            while (nums[i]>=nums[k]){
                k--;
            }
            //swap:A[i],A[k]
            int temp=nums[i];
            nums[i]=nums[k];
            nums[k]=temp;
        }

        //reverse A[j:end]
        for (i=j,j = n-1;  i<j ; i++,j--) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}

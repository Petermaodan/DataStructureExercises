package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 */
public class it_75_颜色分类 {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        new it_75_颜色分类().sortColors(nums);
        ListUtil.arrayOneNums(nums);
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p0=0,p1=0;
        for (int i = 0; i < n; i++) {
            if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[p1];
                nums[p1]=temp;
                ++p1;
            }else if (nums[i]==0){
                //当找到nums[i]==0时，p0和p1都需要自增1
                int temp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=temp;
                //当p0<p1是，必然会把邻着0的1给交换出去,所以要把p1再进行一次交换,实际上就是将1往后移
                if (p0<p1){
                    temp=nums[i];
                    nums[i]=nums[p1];
                    nums[p1]=temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}

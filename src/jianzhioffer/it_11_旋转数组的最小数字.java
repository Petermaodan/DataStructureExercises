package jianzhioffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *

 */
public class it_11_旋转数组的最小数字 {
    public static void main(String[] args) {
//        int[] nums={3,4,5,1,2,3};
//        int[] nums={2,2,2,0,1};
        int[] nums={1,3,5};
        int res=new it_11_旋转数组的最小数字().minArray(nums);
        System.out.println(res);
    }

    //官方二分查找

    public int minArray(int[] numbers) {

        int l=0,r=numbers.length-1;
        while (r>l){
            int mid=l+(r-l)/2;
            if (numbers[mid]<numbers[r]){
                //中间点小于最右边，则右边区间无用
                r=mid;
            }else if (numbers[mid]>numbers[r]){
                //说明最小值在左边区间
                l=mid+1;
            }else {
                //因为存在重复元素，所以唯一可以确定的是右边减一
                r--;
            }
        }
        return numbers[l];
    }
}

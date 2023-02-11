package leetcode.hot100;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 * 采用二分法的解法时间复杂度为O(log(m+n))->不会做
 * 这里采用合并奇偶树的方法求解
 */
public class it_4_寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        int[]nums1 = {1,2}; int[] nums2 = {3,4};
        double res=new it_4_寻找两个有序数组的中位数().findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int left=0,right=0;
        int len=n+m;
        //数组的开头
        int aStart=0,bStart=0;
        //用 len 表示合并后数组的长度，如果是奇数，
        // 我们需要知道第 （len+1）/2 个数就可以了，如果遍历的话需要遍历 int(len/2 ) + 1 次。
        //无论是奇数或是偶数，寻找中位数均需要遍历(len/2)+1次
        for (int i = 0; i <=len/2 ; i++) {
            //用right来储存较大的数字
            left=right;
            if (aStart<n&&(bStart>=m||nums1[aStart]<nums2[bStart])){
                right=nums1[aStart++];
            }else {
                right=nums2[bStart++];
            }
        }
        //判断奇偶(len&1)==0->表示为偶数
        if ((len&1)==0){
            return (left+right)/2.0;
        }else {
            return right/2.0;
        }
    }
//    int m = A.length;
//    int n = B.length;
//    int len = m + n;
//    int left = -1, right = -1;
//    int aStart = 0, bStart = 0;
//    for (int i = 0; i <= len / 2; i++) {
//        left = right;
//        if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//            right = A[aStart++];
//        } else {
//            right = B[bStart++];
//        }
//    }
//    if ((len & 1) == 0)
//            return (left + right) / 2.0;
//    else
//            return right
}

package niuke;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class it_16_子数组的最大累加和 {
    public static void main(String[] args) {
        int[] arr={1, -2, 3, 5, -2, 6, -1};
        int res=new it_16_子数组的最大累加和().maxsumofSubarray(arr);
        System.out.println(res);
    }

    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int n=arr.length;
        if (n<=1)return n;
//        int[] dp=new int[n];
        //base case:
        int dp_i_1=arr[0];
        int dp_i;
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (dp_i_1>0){
                dp_i=dp_i_1+arr[i];
            }else {
                dp_i=arr[i];
            }
            dp_i_1=dp_i;
            max=Math.max(max,dp_i);
        }
        return max;
    }
}

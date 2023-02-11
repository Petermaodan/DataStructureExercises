package leetcode.dailyTest;

import BaseUtil.ListUtil;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]

 */
public class it_1089_复写零 {
    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,4,5,0};
        new it_1089_复写零().duplicateZeros(arr);
        ListUtil.arrayOneNums(arr);
    }
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i]==0){
                afterOne(arr,i);
                if (i!=n-1){
                    arr[++i]=0;
                }
            }
        }
    }

    private void afterOne(int[] arr, int l) {
        for (int i = arr.length-1; i >l ; i--) {
            arr[i]=arr[i-1];
        }
    }
}

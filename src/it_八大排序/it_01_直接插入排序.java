package it_八大排序;

import BaseUtil.ListUtil;

/**
 * 每一轮都会将数组中的元素进行比较
 * 时间复杂度，最好O（n），最坏O（n^2）
 *  * 不会改变相同元素之间的排序，稳定的排序
 */
public class it_01_直接插入排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        insortionSort(arr);
        ListUtil.arrayOneNums(arr);
    }

    private static void insortionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (arr[j-1]<=arr[j]){
                    break;
                }
                swap(arr,j,j-1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}

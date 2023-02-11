package it_八大排序;

import BaseUtil.ListUtil;

/**
 *  时间复杂度，最好O（n），最坏O（n^2）
 * 不会改变相同元素之间的排序，稳定的排序
 */

public class it_05_冒泡排序 {

    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        bubbleSort(arr);
        ListUtil.arrayOneNums(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

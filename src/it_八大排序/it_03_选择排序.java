package it_八大排序;

import BaseUtil.ListUtil;

import java.util.Arrays;

/**
 * 先把前面的拍好，先找到最小的值的下标，遍历完数组之后进行交换
 *  * 时间复杂度，最好O（n^2），最坏O（n^2）
 *  *会改变相同元素之间的排序，不稳定的排序
 */
public class it_03_选择排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        selectSort1(arr);
        ListUtil.arrayOneNums(arr);
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int m=i;//假设i为最小值的下标
            for (int j =i+ 1; j < arr.length; j++) {
                if (arr[j]<arr[m]){
                    m=j;//将下标为j的数赋值为最小值
                }
            }
            if (m!=i){
                swap(arr,i,m);
            }
        }
    }

    private static void swap(int[] arr, int i, int m) {
        int temp=arr[i];
        arr[i]=arr[m];
        arr[m]=temp;
    }

    public static void selectSort1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int m=i;
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<arr[m]){
                    m=j;
                }
            }
            if (m!=i){
                swap(arr,i,m);
            }
        }
    }
}

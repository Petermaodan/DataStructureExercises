package it_八大排序;

import BaseUtil.ListUtil;

import java.util.Arrays;

public class it_07_归并排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        int[] res = mergingSort(arr);
        ListUtil.arrayOneNums(res);
    }
    public static int[] mergingSort(int[] arr){
        //跳出递归的条件
        if (arr.length<=1)return arr;
        int num=arr.length>>1;
        int[] leftArray= Arrays.copyOfRange(arr,0,num);
        int[] rightArray=Arrays.copyOfRange(arr,num,arr.length);
        return mergeTwoArray(mergingSort(leftArray),mergingSort(rightArray));
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i=0,j=0,k=0;
        //申请额外的储存空间
        int[] result=new int[arr1.length+arr2.length];
        while (i<arr1.length&&j<arr2.length) {
            if (arr1[i]<=arr2[j]){
                result[k++]=arr1[i++];
            }else {
                result[k++]=arr2[j++];
            }
        }
        while (i<arr1.length){
            result[k++]=arr1[i++];
        }
        while (j<arr2.length){
            result[k++]=arr2[j++];
        }
        return result;
    }
}

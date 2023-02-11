package it_八大排序;

import java.util.Arrays;

/**
 * 实际为冒泡排序的改进
 * 最好情况O（nlog2n）,最坏情况O（n^2）,辅助空间O（nlog2N）
 */
public class it_06_快速排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int i,int j){

        //跳出递归的条件
        if (arr.length<=0)return;
        if (i>=j)return;

        int left=i,right=j;
        int low=left,high=right;
        int temp=arr[left];
        while (low<high){
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }

        arr[low]=temp;
        quickSort(arr,left,low-1);
        quickSort(arr,low+1,right);
    }
}

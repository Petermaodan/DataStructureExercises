package it_八大排序;

import BaseUtil.ListUtil;

import java.util.PriorityQueue;
import java.util.Queue;

public class it_04_堆排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        heapSort(arr);
        ListUtil.arrayOneNums(arr);
    }
    public static void heapSort(int[] arr){
        //构建大顶堆
        for (int i = arr.length/2-1; i >=0 ; i--) {
            //从第一个非叶子结点从上往下，从右到左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //调整对结构，交换堆顶元素和末尾元素
        for (int i = arr.length-1; i >0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp=arr[i];//取出当前元素
        for (int k = i*2+1; k < length; k=k*2+1) {//从结点的左子节点开始，也就是2i+1
            if (k+1<length&&arr[k]<arr[k+1]){
                //如果左子节点小于右子节点，k指向右子节点
                k++;
            }
            if (arr[k]>temp){
                //如果子节点大于父节点，将子节点赋值给父节点，不用进行交换
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;//将temp放到最终位置
    }
}

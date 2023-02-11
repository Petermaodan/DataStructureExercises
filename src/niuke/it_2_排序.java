package niuke;

import BaseUtil.ListUtil;

import java.util.Random;

public class it_2_排序 {
    Random random=new Random();

    public static void main(String[] args) {
        int[] nums={5,2,3,1,4};
        int[] res=new it_2_排序().MySort(nums);
        ListUtil.arrayOneNums(res);
    }

    public int[] MySort (int[] arr) {
        // write code here
        quickSort(arr,0,arr.length-1);
        return arr;

    }


    public void quickSort(int[] arr,int l,int r){
        if (l>r)return;
        int index=randomPartition(arr,l,r);
        quickSort(arr,l,index-1);
        quickSort(arr,index+1,r);
    }
    //随机变化加速递归过程
    public int randomPartition(int[] arr,int l,int r){
        int i=random.nextInt(r-l+1)+l;
        swap(arr,i,r);
        return partition(arr,l,r);
    }

    public int partition(int[] arr,int l,int r){
        int x=arr[r],i=l-1;
        for (int j = l; j <r ; ++j) {
            if (arr[j]<=x){
                swap(arr,++i,j);
            }
        }
        //将x插入属于他的位置
        swap(arr,i+1,r);
        //中轴位置
        return i+1;
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

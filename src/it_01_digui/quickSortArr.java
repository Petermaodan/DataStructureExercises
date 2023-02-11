package it_01_digui;

public class quickSortArr {
    public static void main(String[] args) {
        int[] arr={52,39,67,95,70,8,25,52};

        partition(arr,0,arr.length-1);
//        Quicksort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }

    public static void partition(int[] arr,int left,int right){

        //基线条件
        if (left<right) {
            int l=left;
            int r=right;
            int pivot=arr[l];//第一个作为致电记录
            while (l<r){    //从表的两端交替地向中间扫描
                while (l<r&&pivot<=arr[r]){
                    r--;
                }
                if (l<r){
                    arr[l]=arr[r];//将比支点小的向前移动
                    l++;
                }
                while (l<r&&pivot>arr[l]){
                    l++;
                }
                if (l<r){
                    arr[r]=arr[l];//将比支点大的向后移动
                    r--;
                }
            }
            arr[l]=pivot;//支点记录到位
            //递归
            partition(arr,left,l-1);
            partition(arr,l+1,right);
        }

    }

    private static void Quicksort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int l1=l,r1=r;
            int z=arr[l];
            while(l1<r1)
            {
                while(arr[r1]>=z&&l1<r1) r1--;
                arr[l1]=arr[r1];
                while(arr[l1]<z&&l1<r1) l1++;
                arr[r1]=arr[l1];
            }
            arr[r1]=z;
            Quicksort(arr,l,r1-1);
            Quicksort(arr,r1+1,r);
        }
    }

//    private void qSort(int[] arr,int left,int right){
//        if (left<right){
//            int pivotLoc=partition(arr,left,right);
//            qSort(arr,left,pivotLoc-1);
//            qSort(arr,pivotLoc,right);
//        }
//    }
}

package it_八大排序;

import BaseUtil.ListUtil;

public class it_08_基数排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        radixSort(arr);
        ListUtil.arrayOneNums(arr);
    }

    public static void radixSort(int[] arr){
        if (arr.length<=1)return;
        //取得数组中的最大数，并取得位数
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //取得位数
        int maxDigit=1;
        while (max/10>0){
            maxDigit++;
            max/=10;
        }

        //申请一个桶空间
        int[][] buckets=new int[10][arr.length];
        int base=10;

        //从低位到高位，将每个数插入桶中
        for (int i = 0; i < maxDigit; i++) {
            //存储各个桶中存储元素的数量
            int[] bktLen=new int[10];
            //分配，将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBuckt=(arr[j]%base)/(base/10);
                buckets[whichBuckt][bktLen[whichBuckt]]=arr[j];
                bktLen[whichBuckt]++;
            }

            //收集；将不同桶里数据挨个捞出，为下一轮高位排序做准备，桶底元素排名靠前，先捞
            int k=0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p <bktLen[b] ; p++) {
                    arr[k++]=buckets[b][p];
                }
            }
            base*=10;
        }
    }

}

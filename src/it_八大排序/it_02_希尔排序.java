package it_八大排序;
/**
 * 希尔排序也叫做缩小增量排序，它通过先设置一个增量n，大小为数组长度的一半，将间隔为n的元素视作一个组，然后对每个组内部的元素进行从小到大进行插入排序；
 * 然后再将增量n缩小一半，再次进行分组插入排序，直到增量n为1，因为增量为1的时候，所有的元素都为同一个组了
 *
 *  * 时间复杂度，最好O（n），最坏O（n^2）
 *  *会改变相同元素之间的排序，不稳定的排序
 */

import BaseUtil.ListUtil;

public class it_02_希尔排序 {
    public static void main(String[] args) {
        int[] arr={63, 76, 13, 44, 91, 8, 82, 3};
        shellSort(arr);
        ListUtil.arrayOneNums(arr);
    }

    public static void shellSort(int[] arr){
        int len=arr.length;

        int interval=len/2;

        //不断缩小间隔的大小，进行分组插入排序
        while (interval>=1){

            // 4. 从 arr[interval] 开始往后遍历，将遍历到的数据与其小组进行插入排序
            for (int i = interval; i < len; i++) {
                int temp=arr[i];
                int j=i;
                //j-interval>=0放在前面，防止越界
                while (j-interval>=0&&arr[j-interval]>temp){
                    //交换
                    arr[j]=arr[j-interval];
                    j-=interval;
                }
                arr[j]=temp;
            }
            //缩小间隔
            interval/=2;
        }
    }
}

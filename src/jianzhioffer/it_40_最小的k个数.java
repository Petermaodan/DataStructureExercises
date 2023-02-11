package jianzhioffer;

import BaseUtil.ListUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class it_40_最小的k个数 {
    public static void main(String[] args) {
//        int[] nums={4,5,1,6,2,7,3,8};
        int[] nums={0,0,0,2,0,5};
        int[] res = new it_40_最小的k个数().getLeastNumbers(nums, 4);
        ListUtil.arrayOneNums(res);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] res=new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i]=arr[i];
//        }
//        return res;

        //使用大堆根，默认是小堆根，所以要重写比较器
        if (k==0||arr.length==0)return new int[]{};
        int[] res=new int[k];
        Queue<Integer> queue=new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int num : arr) {
            if (queue.size()<k){
                queue.offer(num);
            }else {
                if (num<queue.peek()){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll();
        }
        return res;


    }
}

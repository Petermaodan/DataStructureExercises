package jianzhioffer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class it_59_数据流的第K大数值 {
    public static void main(String[] args) {
        new it_59_数据流的第K大数值().run();

    }

    private void run() {
        KthLargest kthLargest=new KthLargest( 3,new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));   // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    class KthLargest {
        PriorityQueue<Integer> queue;
        int k;
        public KthLargest(int k, int[] nums) {
            queue=new PriorityQueue<>();
            this.k=k;
            for (int num : nums) {
                queue.add(num);
            }

        }
        public int add(int val) {
            queue.add(val);
            while (queue.size()>k){
                queue.poll();
            }
            return queue.peek();
        }
    }
}

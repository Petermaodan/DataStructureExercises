package leetcode.moni;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */

public class it_4_实现KthLargest类 {


    //方法一:使用PriorityQueue优先队列
    //构建一个大堆

    /**
     * Queue maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
     * 可以转换为大堆。
     *
     * 思路：构建大小为k的queue，size 小于 k时候进队，大于k时候，添加值与queue.peek （第一个元素）进行比较，若大则将queue出队后再添加进去。
     * 最后返回队第一个元素peek,即为k大的值。
     */
    class KthLargest{
        PriorityQueue queue;
        int k=0;
        public KthLargest(int k, int[] nums) {
            this.k=k;
            queue=new PriorityQueue<Integer>();
            for (int num : nums) {
                if (queue.size()<k){
                    queue.add(num);
                }else {
                    if (num > (int)queue.peek()){
                        queue.poll();
                        queue.add(num);
                    }
                }
            }

        }

        public int add(int val) {
            if (queue.size()<k){
                queue.add(val);
            }else {
                if (val>(int)queue.peek()){
                    queue.poll();
                    queue.add(val);
                }
            }
            return (int) queue.peek();

        }

    }

}

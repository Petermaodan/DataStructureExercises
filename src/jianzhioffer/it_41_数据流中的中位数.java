package jianzhioffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 思路，优先队列，创建一个小顶堆存放较大的元素，大顶堆存放小的元素
 */
public class it_41_数据流中的中位数 {
    public static void main(String[] args) {

    }

    class MedianFinder {
        Queue<Integer> A,B;
        /** initialize your data structure here. */
        public MedianFinder() {
            //小顶堆
            A= new  PriorityQueue<>();
            //大顶堆
            B=new PriorityQueue<>((x,y)->(y-x));
        }

        public void addNum(int num) {
            if (A.size()!=B.size()){
                //要往B添加元素，得先往A添加
                A.add(num);
                B.add(A.poll());
            }else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size()!=B.size()?A.peek():(A.peek()+B.peek())/2.0;
        }
    }
}

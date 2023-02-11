package jianzhioffer;
/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class it_59_2_队列的最大值 {


    class MaxQueue{



        Deque<Integer> d;//双端队列
        Queue<Integer> q;//实现pop_front

        public MaxQueue() {
            d=new LinkedList<>();
            q=new LinkedList<>();

        }

        public int max_value() {
            if (!d.isEmpty()){
                return d.peekFirst();
            }
            return -1;
        }

        public void push_back(int value) {
            //保持双端队列单调递减
            while (!d.isEmpty()&&d.peekLast()<value){
                d.pollLast();
            }
            d.offerLast(value);
            //记录完整队列
            q.offer(value);
        }

        public int pop_front() {
            if (q.isEmpty()){
                return -1;
            }
            int res=q.poll();
            if (res==d.peekFirst()){
                //若弹出的是同一个值，那么需要将双端队列中的值也弹出
                d.pollFirst();
            }
            return res;
        }

//        Queue<Integer> q;
//        Deque<Integer> d;
//
//        public MaxQueue() {
//            q = new LinkedList<Integer>();
//            d = new LinkedList<Integer>();
//        }
//
//        public int max_value() {
//            if (d.isEmpty()) {
//                return -1;
//            }
//            return d.peekFirst();
//        }
//
//        public void push_back(int value) {
//            while (!d.isEmpty() && d.peekLast() < value) {
//                d.pollLast();
//            }
//            d.offerLast(value);
//            q.offer(value);
//        }
//
//        public int pop_front() {
//            if (q.isEmpty()) {
//                return -1;
//            }
//            int ans = q.poll();
//            if (ans == d.peekFirst()) {
//                d.pollFirst();
//            }
//            return ans;
//        }
//
    }
}

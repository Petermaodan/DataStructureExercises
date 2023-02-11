package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 思路：使用一个辅助栈来存放最小值
 */
public class it_30_包含min函数的栈 {


    class MinStack {

        Stack<Integer> stackA;
        Stack<Integer> stackB;

        /**
         * initialize your data structure here.
         */

        //java.util.EmptyStackException
        public MinStack() {
            stackA=new Stack<>();
            //辅助栈B，用来储存逆序的最小值
            stackB=new Stack<>();
        }

        public void push(int x) {
            if (stackB.isEmpty()||stackB.peek()>=x){
                stackB.add(x);
            }
            stackA.add(x);
        }

        public void pop() {
            //这里不能使用简单的等于，因为是两个对象
            //若同时存在，则B栈的也要出栈
            if (stackA.pop().equals(stackB.peek())){
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }
}

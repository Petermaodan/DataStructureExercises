package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class it_09_用两个栈实现队列 {

     class CQueue {

         Stack<Integer> stackA;
         Stack<Integer> stackB;


        public CQueue() {
            this.stackA=new Stack<>();
            this.stackB=new Stack<>();
        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {
            if (stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
            }
            if (stackB.isEmpty()){
                return -1;
            }else {
                return stackB.pop();
            }
        }
    }
}

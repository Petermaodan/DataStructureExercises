package niuke;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 思路：
 * 当插入时，直接插入 stack1
 * 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
 */

import java.util.Stack;

public class it_13_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2==null){
            while (stack1!=null){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

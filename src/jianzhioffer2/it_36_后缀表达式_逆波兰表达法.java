package jianzhioffer2;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class it_36_后缀表达式_逆波兰表达法 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = new it_36_后缀表达式_逆波兰表达法().evalRPN(tokens);
        System.out.println(res);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String token : tokens) {
            if (!(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))){
                stack.add(Integer.valueOf(token));
                continue;
            }
            int x=stack.pop();
            int y=stack.pop();
            int temp = 0;
            if (token.equals("+")){
                temp=x+y;
            }else if (token.equals("-")){
                temp=y-x;
            }else if (token.equals("*")){
                temp=x*y;
            }else if (token.equals("/")){
                temp=y/x;
            }
            stack.add(temp);
        }
        return stack.peek();
    }
}

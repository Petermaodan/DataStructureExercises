package it_14_实现计算器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        String s="3*(4-5/2)-6+5";
        int result=calculate(s);
        System.out.println(result);
    }

    private static int calculate(String s) {
        Queue<Character> s1=new LinkedList<>();
        for (int i = 0; i <s.length() ; i++) {
            s1.offer(s.charAt(i));
        }
        return helper(s1);
    }

    private static int helper(Queue<Character> s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        //记录num前的符号，初始化为+
        char sign='+';
        while (!s.isEmpty()) {
                char c=s.poll();
                //如果是数字，连续读取到num
                if (Character.isDigit(c)){
                    //因为变量c是一个 ASCII 码，如果不加括号就会先加后减，
                    // 想象一下n如果接近 INT_MAX，就会溢出。所以用括号保证先减后加才行。
                    num=10*num+ (c-'0');
                }

                if (c=='('){
                    //换句话说，括号包含的算式，我们直接视为一个数字就行了。
                    //现在的问题是，递归的开始条件和结束条件是什么？
                    // 遇到(开始递归，遇到)结束递归：
                    num=helper(s);
                }


                //如果不是数字，就是要遇到了下一个符号之前的数字和符号要存入栈中
                //空格也要注意
                if (!Character.isDigit(c)&&c!=' '||s.isEmpty()){
                    switch (sign){
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        //遇到乘除，只要拿出前一个数字做对应的运算即可
                        case '*':
                            int pre1=stack.peek();
                            stack.pop();
                            stack.push(pre1*num);
                            break;
                        case '/':
                            int pre2=stack.peek();
                            stack.pop();
                            stack.push(pre2/num);
                            break;
                    }
                    //更新当前符号，数字清零
                    sign=c;
                    num=0;
                }
                if (c==')'){
                    break;
                }
            }
        //将栈中的所有结果求和就是答案
        int res=0;
        while (!stack.empty()){
            res+=stack.peek();
            stack.pop();
        }
        return res;
    }
}

package it_14_实现计算器;

import java.util.Stack;

/**
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分
 */
public class Test2 {
    public static void main(String[] args) {
        String s="3+2*2";
        int result=new Test2().calculate(s);
        System.out.println(result);
    }

    public int calculate(String s){
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char sign='+';
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if (!Character.isDigit(c)&&c!=' '||i==s.length()-1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
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
                num=0;
                sign=c;
            }
        }
        int res=0;
        while (!stack.empty()){
            res+=stack.peek();
            stack.pop();
        }
        return res;
    }
}

package niuke;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 算法：栈
 * 1.用栈保存各部分计算的和
 * 2.遍历表达式，使用 sign 变量记录运算符，初始化是 '+'；使用 number 变量记录字符串中的数字部分的数字值是多少
 * 2.0 遇到空格时跳过
 * 2.1 遇到数字时继续遍历求这个完整的数字的值，保存到 number 中
 * 2.2 遇到左括号时递归求这个括号里面的表达式的值
 * 先遍历找到对应的右括号，因为可能里面还嵌有多对括号，使用一个变量 counterPartition 统计括号对数直到变量为 0
 * 2.3 遇到运算符时或者到表达式末尾时，就去计算上一个运算符并把计算结果 push 进栈，然后保存新的运算符到 sign
 * 如果是 + ，不要计算，push 进去
 * 如果是 - ，push 进去负的当前数
 * 如果是 ×、÷ ，pop 出一个运算数和当前数作计算
 * 3.最后把栈中的结果求和即可
 */
public class it_137_表达式求值_基本计算器的改进版 {
    public static void main(String[] args) {
        String s="(2*(3-4))*5";
        int res = new it_137_表达式求值_基本计算器的改进版().calculate(s);
        int res2 = new it_137_表达式求值_基本计算器的改进版().calculate2(s);
        System.out.println(res+" "+res2);
    }
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack=new Stack<>();
        int number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();
        for (int i = 0, n = charArray.length; i < n; i++) {
            char c = charArray[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (charArray[j] == '(') {
                        counterPartition++;
                    }
                    if (charArray[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = calculate(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


    public int calculate2(String s){
        s.trim();
        char[] chars = s.toCharArray();
        char sign='+';
        int number=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (chars[j] == '(') {
                        counterPartition++;
                    }
                    if (chars[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = calculate(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c)||i==chars.length-1){
                switch(sign){
                    case '+':
                        stack.add(number);
                        break;
                    case '-':
                        stack.add(-1*number);
                        break;
                    case '*':
                        stack.add(stack.pop()*number);
                        break;
                    case '/':
                        stack.add(stack.pop()/number);
                        break;
                }
                number=0;
                sign=c;
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}

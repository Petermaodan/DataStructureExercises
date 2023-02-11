package niuke;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class it_20_括号序列 {
    public static void main(String[] args) {
        String s="[][{[{{}}[][]{{}}]}]";
        boolean res=new it_20_括号序列().isValid(s);
        System.out.println(res);

    }

    public boolean isValid (String s) {
        // write code here

        Deque<Character> stack=new ArrayDeque<>();
        char[] ss=s.toCharArray();
        for (char c : ss) {
            if (c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if (stack.size()!=0&&stack.peek()!=')'&&stack.peek()!='}'&&stack.peek()!=']'){
                    switch (c){
                        case ')':
                            if (stack.peek()=='('){
                                stack.poll();
                            }
                            break;
                        case '}':
                            if (stack.peek()=='{'){
                                stack.poll();
                            }
                            break;
                        case ']':
                            if (stack.peek()=='['){
                                stack.poll();
                            }
                            break;
                    }
                }else {
                return false;
            }
        }
        return stack.size()==0;

    }
}

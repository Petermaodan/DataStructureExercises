package jianzhioffer;

import java.util.Stack;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。

 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

 思路，双指针倒叙，
 */
public class it_58_1_翻转单词顺序 {
    public static void main(String[] args) {
        String s="a good         example";
        String res=new it_58_1_翻转单词顺序().reverseWords(s);
        System.out.println(res);
    }



//实际上可以通过逆着遍历将栈优化掉
    public String reverseWords(String s) {
        s.trim();//删除头尾空格-》
        Stack<String> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        int i=0,j=0;
        int len=s.length();
        while (j<len){
            while (j<len&&s.charAt(j)!=' ')j++;
            stack.push(s.substring(i,j));
            while (j<len&&s.charAt(j)==' ')j++;
            i=j;
        }
        while (!stack.isEmpty()){
            if (stack.peek()!=" "){
                res.append(stack.pop()).append(" ");
            }
        }
        return res.toString().trim();
    }
}

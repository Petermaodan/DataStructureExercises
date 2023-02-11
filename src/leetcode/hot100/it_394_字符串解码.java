package leetcode.hot100;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
 *
 */
public class it_394_字符串解码 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new it_394_字符串解码().decodeString(s));
    }



    //方法一：辅助栈操作
    public String decodeString(String s) {
        Stack<Integer> stack_multi=new Stack<>();
        Stack<String> stack_res=new Stack<>();
        StringBuilder res=new StringBuilder();
        int multi=0;//统计[之前的次数
        for (char c : s.toCharArray()) {
            if (c=='['){
                stack_multi.push(multi);
                stack_res.push(res.toString());
                //重置
                multi=0;
                res=new StringBuilder();
            }else if (c==']'){
                StringBuilder tmp=new StringBuilder();
                //出栈
                int cur_multi=stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                //拼接
                res=new StringBuilder(stack_res.pop()+tmp);
            }else if (c<='9'&&c>='0'){
                //将字符c转化为数字c,当multi>9事，需要进一位
                multi=multi*10+c-'0';
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

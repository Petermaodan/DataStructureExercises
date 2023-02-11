package leetcode.dailyTest;

import java.util.Stack;

/**
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 *
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * 示例 1：
 *
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
public class it_1021_删除最外层的括号 {
    public static void main(String[] args) {
        String s = "(()())(())";
        String res = new it_1021_删除最外层的括号().removeOuterParentheses(s);
        System.out.println(res);
    }
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                if (stack.isEmpty()){
                    chars[i]=0;
                }
                stack.push('(');
            }else if ((!stack.isEmpty())&&chars[i]==')'){
                if (stack.size()==1){
                    chars[i]=0;
                }
                stack.pop();
            }
        }
        StringBuilder builder=new StringBuilder();
        for (char aChar : chars) {
            if (aChar==0){
                continue;
            }
            builder.append(aChar);
        }
        return builder.toString();
    }
}

package jianzhioffer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串 。
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 */
public class it_18_有效的回文 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new it_18_有效的回文().isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (Character.isLetter(c)||Character.isDigit(c)){
                list.add(Character.toLowerCase(c));
            }
        }
        for (int i = 0,j=list.size()-1; i <j ; i++,j--) {
            if (list.get(i)!=list.get(j)){
                return false;
            }
        }
        return true;
    }
}

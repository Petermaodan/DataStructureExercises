package jianzhioffer;

import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "

 */
public class it_50_第一个只出现一次的字符 {
    public static void main(String[] args) {
        String s="abaccdeff";
        char res = new it_50_第一个只出现一次的字符().firstUniqChar(s);
        System.out.println(res);
    }
    public char firstUniqChar(String s) {
        int n=s.length();
        if (n==0)return ' ';

        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < n; i++) {
            char c=s.charAt(i);
            if (map.get(c)==1){
                return c;
            }
        }
        return ' ';
    }
}

package leetcode.dailyTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 */
public class it_1417_重新格式化字符串 {
    public static void main(String[] args) {
        String s = "covid2019";
        String reformat = new it_1417_重新格式化字符串().reformat(s);
        System.out.println(reformat);
    }
    public String reformat(String s) {
        int n=s.length();
        StringBuilder builder=new StringBuilder();
        List<Integer> numList=new ArrayList<>();
        List<Character> charList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c=s.charAt(i)-'0';
            if (0 <= c&&c<=9){
                numList.add(c);
            }else {
                charList.add(s.charAt(i));
            }
        }
        int len1=numList.size(),len2=charList.size();
        if (Math.abs(len1-len2)>1){
            return "";
        }
        int len=Math.min(len1,len2);
        for (int i = 0; i < len; i++) {
            builder.append(numList.get(i));
            builder.append(charList.get(i));
        }
        if (len1>len2){
            builder.append(numList.get(len1-1));
        }else if (len2>len1){
            builder.reverse().append(charList.get(len2-1));
        }
        return builder.toString();
    }
}

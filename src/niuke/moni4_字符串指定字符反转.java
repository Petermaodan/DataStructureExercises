package niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个字符串，，将中的包含在中的字符翻转。
 *
 * 输入例子1:
 * "abcde","bcd"
 *
 * 输出例子1:
 * "adcbe"
 */
public class moni4_字符串指定字符反转 {
    public static void main(String[] args) {
//        String s1="acbde";
//        String s2="dc";
        String s1="abcde";
        String s2="bcd";
        String res=new moni4_字符串指定字符反转().reverse(s1,s2);
        System.out.println(res);
    }
    public String reverse (String s1, String s2) {
        // write code here
        Set<Character> hashSet=new HashSet<>();
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        for (char c : c2) {
            hashSet.add(c);
        }
        int l=0,r=c1.length-1;
        while (l<r){
            while (!hashSet.contains(c1[l])){
                l++;
            }
            while (!hashSet.contains(c1[r])){
                r--;
            }
            char temp=c1[l];
            c1[l]=c1[r];
            c1[r]=temp;
            l++;
            r--;
        }
        return String.valueOf(c1);
    }
}

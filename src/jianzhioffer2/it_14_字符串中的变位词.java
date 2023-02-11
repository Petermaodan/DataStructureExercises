package jianzhioffer2;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
public class it_14_字符串中的变位词 {
    public static void main(String[] args) {
        String s1 = "adc",s2 = "dcda";
        boolean res = new it_14_字符串中的变位词().checkInclusion(s1, s2);
        System.out.println(res);
    }
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        if(n>m){
            return false;
        }
        int[] countS1=new int[26];
        int[] countS2=new int[26];
        for (int i = 0; i < n; i++) {
            countS1[s1.charAt(i)-'a']++;
            countS2[s2.charAt(i)-'a']++;
        }
        for (int l = 0,r=n; r<m ;l++,r++) {
            if (Arrays.equals(countS1,countS2)){
                return true;
            }
            countS2[s2.charAt(r)-'a']++;
            countS2[s2.charAt(l)-'a']--;
        }
        if (Arrays.equals(countS1,countS2)){
            return true;
        }
        return false;
    }
}

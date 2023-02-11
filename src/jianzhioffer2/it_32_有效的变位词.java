package jianzhioffer2;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 *
 */
public class it_32_有效的变位词 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean res = new it_32_有效的变位词().isAnagram(s, t);
        System.out.println(res);
    }

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }
        int[] count=new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;

        }
        for (int i = 0; i < t.length(); i++) {
            if (--count[t.charAt(i)-'a']<0){
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i]!=0){
                return false;
            }
        }
        return true;
    }
}

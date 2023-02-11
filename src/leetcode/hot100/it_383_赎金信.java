package leetcode.hot100;

/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 */
public class it_383_赎金信 {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        boolean res = new it_383_赎金信().canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count=new int[26];
        int r=ransomNote.length(),m=magazine.length();
        for (int i = 0; i < m; i++) {
            int temp=magazine.charAt(i)-'a';
            count[temp]++;
        }
        for (int i = 0; i < r; i++) {
            int temp=ransomNote.charAt(i)-'a';
            count[temp]--;
            if (count[temp]<0){
                return false;
            }
        }
        return true;
    }
}

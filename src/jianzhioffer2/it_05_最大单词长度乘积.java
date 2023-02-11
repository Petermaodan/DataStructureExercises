package jianzhioffer2;

/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 基本思路，肯定要遍历每个单词
 *
 */
public class it_05_最大单词长度乘积 {
    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","fxyz","abcdef"};
        int res = new it_05_最大单词长度乘积().maxProduct(words);
        System.out.println(res);
    }
    public int maxProduct(String[] words) {
        int res=0;
        for (int i = 0; i < words.length-1; i++) {
            String s1=words[i];
            for (int j = i+1; j <words.length ; j++) {
                String s2=words[j];
                if (!isHasSameChar3(s1,s2)){
                    res=Math.max(res,s1.length()*s2.length());
                }
            }
        }
        return res;
    }

    private boolean isHasSameChar3(String s1, String s2) {
        int bitMask1=0,bitMask2=0;
        for (char c : s1.toCharArray()) {
            bitMask1|=(1<<(c-'a'));
        }
        for (char c : s2.toCharArray()) {
            bitMask2|=(1<<(c-'a'));
        }
        return (bitMask1&bitMask2)!=0;
    }

    private boolean isHasSameChar2(String s1, String s2) {
        int[] count=new int[26];
        for (char c : s1.toCharArray()){
            count[c-'a']++;
        }
        for (char c : s2.toCharArray()) {
            if (count[c-'a']>0){
                return true;
            }
        }
        return false;
    }

    private boolean isHasSameChar(String s1, String s2) {
        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c)!=-1){
                return true;
            }
        }
        return false;
    }
}

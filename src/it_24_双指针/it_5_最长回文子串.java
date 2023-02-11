package it_24_双指针;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。

 从中间向两边扩散来判断回文子串，需要区分奇偶数

 */
public class it_5_最长回文子串 {
    public static void main(String[] args) {
        String s="babad";
        String res=new it_5_最长回文子串().longestPalindrome(s);
        System.out.println(res);

    }
    public String longestPalindrome(String s) {
        //遍历整个数组
        String res="";
        for (int i = 0; i < s.length(); i++) {
            String temp=palindrome(s,i,i);

            String temp2=palindrome(s,i,i+1);
            res=res.length()>temp.length()?res:temp;
            res=res.length()>temp2.length()?res:temp2;
        }
        return res;
    }

    private String palindrome(String s, int i, int j) {
        while (i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}

package jianzhioffer2;

/**
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。

 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 */
public class it_19_最多删除一个字符得到回文 {
    public static void main(String[] args) {
        String s = "abca";
        boolean b = new it_19_最多删除一个字符得到回文().validPalindrome(s);
        System.out.println(b);
    }
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while (l<r){
            if (s.charAt(l)==s.charAt(r)){
                l++;
                r--;
                continue;
            }else if (valid(s,l+1,r)||valid(s,l,r-1)){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean valid(String s, int i, int j) {
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}

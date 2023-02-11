package leetcode.hot100;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * 示例 1：
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 */
public class it_917_仅仅反转字母 {
    public static void main(String[] args) {
        String s = "ab-cd";
        String res = new it_917_仅仅反转字母().reverseOnlyLetters(s);
        System.out.println(res);
    }
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l=0,r=chars.length-1;
        while (l<r){
            while (l<r&&!Character.isLetter(chars[l])){
                l++;
            }
            while (l<r&&!Character.isLetter(chars[r])){
                r--;
            }
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }


}

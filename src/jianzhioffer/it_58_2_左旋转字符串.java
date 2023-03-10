package jianzhioffer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class it_58_2_左旋转字符串 {
    public static void main(String[] args) {
        String s="abcdefg";
        int k=2;
        String res = new it_58_2_左旋转字符串().reverseLeftWords(s, k);
        System.out.println(res);
    }
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb=new StringBuilder();
        sb.append(s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
    }
}

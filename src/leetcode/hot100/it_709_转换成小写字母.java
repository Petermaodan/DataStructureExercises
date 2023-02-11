package leetcode.hot100;

/**
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello"
 * 输出："hello"
 * 示例 2：
 *
 * 输入：s = "here"
 * 输出："here"
 * 示例 3：
 *
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *
 */
public class it_709_转换成小写字母 {
    public static void main(String[] args) {
        String s="Hello";
        String res = new it_709_转换成小写字母().toLowerCase(s);
        System.out.println(res);
    }
    public String toLowerCase(String s) {
        StringBuilder builder=new StringBuilder();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char temp=s.charAt(i);
            if (temp>='A'&&temp<='Z'){
                builder.append(Character.toLowerCase(temp));
            }else {
                builder.append(temp);
            }
        }
        return builder.toString();
    }
}

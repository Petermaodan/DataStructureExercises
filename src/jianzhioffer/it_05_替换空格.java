package jianzhioffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class it_05_替换空格 {
    public static void main(String[] args) {
        String s="We are happy.";
        String res=new it_05_替换空格().replaceSpace(s);
        System.out.println(res);
    }

    public String replaceSpace(String s) {
        StringBuilder builder=new StringBuilder();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)!=' '){
                builder.append(s.charAt(i));
            }else {
                builder.append("20%".toCharArray());
            }
        }
        return builder.toString();
    }
}

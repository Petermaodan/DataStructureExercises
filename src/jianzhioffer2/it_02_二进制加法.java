package jianzhioffer2;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class it_02_二进制加法 {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String res = new it_02_二进制加法().addBinary(a, b);
        System.out.println(res);
    }
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        StringBuilder builder=new StringBuilder();
        int carry=0;
        while (i>=0||j>=0){
            int x=i>=0?a.charAt(i)-'0':0;
            int y=j>=0?b.charAt(j)-'0':0;
            int sum=carry+x+y;
            builder.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        if (carry>0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}

package leetcode.hot100;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class it_67_二进制求和 {
    public static void main(String[] args) {
        String a="111";
        String b="11";
        String res = new it_67_二进制求和().addBinary(a, b);
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        StringBuilder builder=new StringBuilder();
        int lenA=a.length()-1;
        int lenB=b.length()-1;
        int carry=0;
        while (lenA>=0||lenB>=0){
            int sum=carry;
            int x=lenA>=0?a.charAt(lenA)-'0':0;
            int y=lenB>=0?b.charAt(lenB)-'0':0;

            sum+=x;
            sum+=y;
            System.out.println(sum);
            builder.append(sum%2);
            carry=sum/2;
            lenA--;
            lenB--;
        }
        builder.append(carry==1?carry:"");
        return builder.reverse().toString();
    }
}

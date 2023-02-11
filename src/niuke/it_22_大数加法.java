package niuke;

public class it_22_大数加法 {
    public static void main(String[] args) {
        String s = "123456";
        String t = "123456";
        String res = new it_22_大数加法().solve(s, t);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        StringBuilder ss = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1;
        int carry = 0;
        //特别注意carry！=0这个判断条件
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            ss.append(sum % 10);
            carry = sum / 10;
        }
        //记得反转字符
        return ss.reverse().toString();

    }
}

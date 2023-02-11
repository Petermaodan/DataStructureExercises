package leetcode.dailyTest;
/**给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 示例 1:
 输入: num = 100
 输出: "202"
 **/
public class it_504_七进制数 {
    public static void main(String[] args) {
        int num=-7;
        String s = new it_504_七进制数().convertToBase7(num);
        System.out.println(s);
    }
    public String convertToBase7(int num) {
        StringBuilder builder=new StringBuilder();
        boolean flag=num>0;
        num=Math.abs(num);
        while (num>0){
            builder.append(num%7);
            num/=7;
        }
        return flag?builder.reverse().toString():"-"+builder.reverse().toString();
    }
}

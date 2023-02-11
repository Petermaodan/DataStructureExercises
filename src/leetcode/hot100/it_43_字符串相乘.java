package leetcode.hot100;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class it_43_字符串相乘 {
    public static void main(String[] args) {
        String num1="9133",num2="0";
        String res = new it_43_字符串相乘().multiply(num1, num2);
        System.out.println(res);
    }
    public String multiply(String num1, String num2) {
//        if (num1=="0"||num2=="0")return "0";
        int count=0;
        String res="";
        int i=num1.length()-1;
        while (i>=0){
            int temp=num1.charAt(i--)-'0';
            String tempS=multiplyString(num2,temp,count);
            res=addString(res,tempS);
            count++;
        }
        return res.charAt(0)=='0'?"0":res;
    }

    public String multiplyString(String s,int temp,int count){
        StringBuilder builder=new StringBuilder();
        int i=s.length()-1;
        int carry=0;
        while (i>=0||carry!=0){
            int x=i>=0?s.charAt(i--)-'0':0;
            int multiplySum=temp*x+carry;
            builder.append(multiplySum%10);
            carry=multiplySum/10;
        }
        builder.reverse();
        for (int j = 0; j < count; j++) {
            builder.append(0);
        }
        return builder.toString();
    }

    public String addString(String s1,String s2){
        StringBuilder builder=new StringBuilder();
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        while (i>=0||j>=0||carry!=0){
            int x=i>=0?s1.charAt(i--)-'0':0;
            int y=j>=0?s2.charAt(j--)-'0':0;
            int sum=x+y+carry;
            builder.append(sum%10);
            carry=sum/10;
        }
        return builder.reverse().toString();
    }
}

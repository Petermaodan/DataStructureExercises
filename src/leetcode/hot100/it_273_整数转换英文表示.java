package leetcode.hot100;

/**
 * 将非负整数 num 转换为其对应的英文表示。
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 */
public class it_273_整数转换英文表示 {
    public static void main(String[] args) {
        int num=123;
        String res = new it_273_整数转换英文表示().numberToWords(num);
        System.out.println(res);
    }
    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };

    public String numberToWords(int num) {
        if (num==0)return num2str_small[0];
        StringBuilder builder=new StringBuilder();
        for (int i = (int) 1e9,j=0; i >=1 ; i/=1000,j++) {
            if (num<i)continue;
            builder.append(num2Str(num/i)).append(num2str_large[j]).append(" ");
            num%=i;
        }
        while (builder.charAt(builder.length()-1)==' ')builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    private String num2Str(int i) {
        String ans="";
        if (i>=100){
            ans=ans+num2str_small[i/100]+" Hundred ";
            i%=100;
        }
        if (i>=20){
            ans=ans+num2str_medium[i/10]+" ";
            i%=10;
        }
        if (i!=0){
            ans=ans+num2str_small[i]+" ";
        }
        return ans;
    }
}

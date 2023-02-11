package jianzhioffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class it_66_不用加减乘除做加法 {
    public static void main(String[] args) {
        int a=1,b=1;
        System.out.println(new it_66_不用加减乘除做加法().add(a,b));
    }
    public int add(int a, int b) {
        while (b!=0){
            int c=(a&b)<<1;//进位
            a^=b;//非进位和
            b=c;
        }
        return a;
    }
}

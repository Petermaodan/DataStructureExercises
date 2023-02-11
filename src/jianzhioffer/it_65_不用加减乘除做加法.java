package jianzhioffer;

public class it_65_不用加减乘除做加法 {

    public static void main(String[] args) {
        int a=1,b=1;
        int res=new it_65_不用加减乘除做加法().add(a,b);
        System.out.println(res);
    }
    public int add(int a, int b) {
        while (b!=0){
            int c=(a&b)<<1;//进位和
            a=a^b;//非进位和
            b=c;
        }
        return a;
    }
}

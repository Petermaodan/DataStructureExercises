package jianzhioffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 */
public class it_43_1_n整数中1出现的次数 {
    public static void main(String[] args) {
        int n=13;
        System.out.println(new it_43_1_n整数中1出现的次数().countDigitOne(n));
    }
    public int countDigitOne(int n) {
        int high=n/10;
        int cur=n%10;
        int low=0,digit=1;
        int res=0;
        while (high!=0||cur!=0){
            if (cur==0){
                res+=high*digit;
            }else if (cur==1){
                res+=high*digit+low+1;
            }else {
                res+=(high+1)*digit;
            }

            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }
        return res;
    }
}

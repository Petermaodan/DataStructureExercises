package niuke;

import java.util.Scanner;

/**
 * 多多君最近在研究某种数字组合：
 * 定义为：每个数字的十进制表示中(0~9)，每个数位各不相同且各个数位之和等于N。
 * 满足条件的数字可能很多，找到其中的最小值即可
 *

 //每个数位各不相同且各个数位之和等于N——1+2+3+4+5+6+7+8+9 = 45，如果大于45一定会重复
 * //右侧数位越大，越能保证左侧数位越小，越能保证整个数最小
 *
 */
public class it_6_多多的数字组合 {
    public static void main(String[] args) {
        int N= new Scanner(System.in).nextInt();

        if (N>45){
            System.out.println(-1);
            return;
        }
        if (N<10){
            System.out.println(N);
            return;
        }
        //右侧数位越大，越能保证左侧数位越小，越能保证整个数最小
        int digit=0;
        int num=0;
        for (int i = 9; i >0 ; i--) {
            if (N!=0&&i<=N){
                N-=i;
                num+=Math.pow(10,digit)*i;
                digit++;
            }
        }
        System.out.println(num);

    }

}

package niuke;

/**
 * 交换任意两个相邻的字符，代价为0。
 * 将任意一个字符a修改成字符b，代价为 |a - b|（绝对值）。
 * 现在有两个长度相同的字符串X和Y，多多君想知道，如果要将X和Y变成两个一样的字符串，需要的最少的代价之和是多少
 */

import java.util.Arrays;
import java.util.Scanner;

public class it_7_多多的字符变换 {
    public static void main(String[] args) {
        int N=new Scanner(System.in).nextInt();
        String S1=new Scanner(System.in).nextLine();
        String S2=new Scanner(System.in).nextLine();
        int res=0;
        char[] a=S1.toCharArray();
        char[] b=S2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < N; i++) {
            res+=Math.abs(S1.charAt(i)-S2.charAt(i));
        }
        System.out.println(res);

    }
}

package niuke;

import java.util.Scanner;

public class moni6_数列均值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int res = 0;

        float value = (float) ((b - c) * 0.5 + a * 1.5);

        res =value<=0?0: (int) Math.round(value / 1.5);



        System.out.println(res);
    }
}

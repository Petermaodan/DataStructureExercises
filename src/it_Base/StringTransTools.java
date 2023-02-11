package it_Base;

import java.util.Scanner;

public class StringTransTools {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String res = s.replaceAll("\\[", "{").replaceAll("]", "}");

        System.out.println(res);
    }
}

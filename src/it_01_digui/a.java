package it_01_digui;

public class a {
    public static void main(String[] args) {
        countdown(5);

    }

    public static void countdown(int i){
        if (i>=0){
            System.out.println(i);
            countdown(i-1);
        }else {
            return;
        }
    }
}

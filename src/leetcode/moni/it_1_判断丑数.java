package leetcode.moni;

public class it_1_判断丑数 {
    public static void main(String[] args) {
        int n=6;
        boolean res=new it_1_判断丑数().isUgly(n);
        System.out.println(res);
    }

    public boolean isUgly(int n) {
        if (n>1){
            while (n%2==0){
                n/=2;
            }
            while (n%3==0){
                n/=3;
            }
            while (n%5==0){
                n/=5;
            }
        }
        return n==1;
    }

}

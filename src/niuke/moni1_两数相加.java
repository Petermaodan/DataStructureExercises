package niuke;

public class moni1_两数相加 {
    public static void main(String[] args) {
        int a=2,b=3;
        System.out.println(new moni1_两数相加().NNAplusB(a,b));
    }


    public long NNAplusB (int a, int b) {
        // write code here
        long aa = a,bb = b;
        for (int i = 1; i < a; i++) {
            bb=bb*10+b;
        }
        for (int i = 1; i < b; i++) {
            aa=aa*10+a;
        }
        return aa+bb;
    }
}

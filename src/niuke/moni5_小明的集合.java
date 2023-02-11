package niuke;

public class moni5_小明的集合 {
    public static void main(String[] args) {
        int n=10;
        int res=new moni5_小明的集合().getSize(n);
        System.out.println(res);
    }
    public int getSize (long n) {
        // write code here
        int res=0;
        while (n!=0){
            n/=2;
            res++;
        }
        return res;


    }
}

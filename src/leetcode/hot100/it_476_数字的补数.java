package leetcode.hot100;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 */
public class it_476_数字的补数 {
    public static void main(String[] args) {
        int num=5;
        int res = new it_476_数字的补数().findComplement(num);
        System.out.println(res);
    }
    public int findComplement(int num) {
        int res=0;
        int pow=0;
        while (num!=0){
            if ((num&1)!=1){
                res+=Math.pow(2,pow);
            }
            pow++;
            num>>=1;
        }
        return res;
    }
}

package niuke;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−2
 * 31
 *  ,2
 * 31
 *  −1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 *
 * 数据范围：
 * 要求：空间复杂度 ，时间复杂度
 */
public class NC_57_反转数字 {
    public static void main(String[] args) {
        int x=-123;
        int res = new NC_57_反转数字().reverse(x);
        System.out.println(res);
    }

    public int reverse (int x) {
        // write code here
        long res=0;
        while (x!=0){
            int temp=x%10;
            res=res*10+temp;
            if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
                return 0;
            }
            x/=10;
        }
        return (int)res;
    }
}

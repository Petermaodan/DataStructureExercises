package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class it_338_比特位计数 {

    public static void main(String[] args) {
        int num=5;
        int[] res=new it_338_比特位计数().countBits(num);
        ListUtil.arrayOneNums(res);
    }
    //最低有效位，将二进制右移一位，等价将最低位去掉，得到[x/2],这样可以通过bits[x/2]得到bits[x];
    //i&1->用来判断是奇数还是偶数，如果是奇数，就+1；
    public int[] countBits(int num) {
        int[] bits=new int[num+1];
        for (int i = 1; i <=num ; i++) {
            ////i&1->用来判断是奇数还是偶数，如果是奇数，就+1；
            bits[i]=bits[i>>1]+(i&1);
        }
        return bits;

    }

    //根据方法一逆向思维，就是动态规划，当前的状态由前一个状态决定，即bits[x]=bits[x&(x-1)]+1;base case bits[0]=0;
    //最低设置位
    public int[] countBits2(int num) {
        int[] bits=new int[num+1];
        for (int i = 1; i <=num ; i++) {
            bits[i]=bits[i&(i-1)]+1;
        }
        return bits;
    }


    //方法一：直接计算，利用位与运算的性质x=x&(x-1);该运算将x二进制的最后一个1，变为0，重复操作，直到x为0，
    public int[] countBits3(int num) {
        int[] bits=new int[num+1];
        for (int i = 0; i <= num; i++) {
            bits[i]=countOnes(i);
        }
        return bits;
    }
    private int countOnes(int x) {
        int ones=0;
        while (x>0){
            x&=(x-1);
            ones++;
        }
        return ones;
    }


}

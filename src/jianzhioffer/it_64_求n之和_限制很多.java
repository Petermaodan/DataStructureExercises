package jianzhioffer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class it_64_求n之和_限制很多 {
    public static void main(String[] args) {
        int res = new it_64_求n之和_限制很多().sumNums(9);
        System.out.println(res);
    }

    int res=0;
    public int sumNums(int n) {
        boolean flag=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}

package jianzhioffer;

import java.util.ArrayList;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 */
public class it_62_圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        int res = new it_62_圆圈中最后剩下的数字().lastRemaining(5, 3);
        System.out.println(res);

    }

    public int lastRemaining(int n, int m) {

        //方法一：使用ArrayList模拟链表
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(i);
        }

        //需要删除的下标
        int idx=0;
        while (n>1){
            //当超过索引时，要从头开始取
            idx=(idx+m-1)%n;
            res.remove(idx);
            n--;
        }
        return res.get(0);
    }
}

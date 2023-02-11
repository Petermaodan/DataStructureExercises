package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。

 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 */
public class it_66_加一 {
    public static void main(String[] args) {
        int[] digits={1,2,3};
        int[] ints = new it_66_加一().plusOne(digits);
        ListUtil.arrayOneNums(ints);
    }
    public int[] plusOne(int[] digits) {
        List<Integer> list=new ArrayList<>();
        int temp=1;
        for (int i = digits.length-1; i >=0 ; i--) {
            temp+=digits[i];
            list.add(temp%10);
            temp/=10;
        }
        if (temp!=0)list.add(temp);

        int len=list.size();
        int[] res=new int[len];
        int j=len-1;
        for (int i = 0; i < len; i++) {
            res[i]=list.get(j--);
        }
        return res;
    }
}

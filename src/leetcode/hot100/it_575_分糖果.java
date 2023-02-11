package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 *
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 */
public class it_575_分糖果 {
    public static void main(String[] args) {
        int[] candies={1,1,2,3};
        int res = new it_575_分糖果().distributeCandies(candies);
        System.out.println(res);
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set=new HashSet<>();
        int max=candyType.length/2;
        for (int num : candyType) {
            if (!set.contains(num)){
                set.add(num);
            }
        }
        return set.size()>=max?max:set.size();

    }
}

package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 *
 */
public class it_846_一手顺子 {
    public static void main(String[] args) {
        int[] hand={1,2,3,4,5};
        boolean nStraightHand = new it_846_一手顺子().isNStraightHand(hand, 3);
        System.out.println(nStraightHand);

    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> queue1=new PriorityQueue();
//        PriorityQueue queue2=new PriorityQueue();

        for (int i : hand) {
            queue1.add(i);
        }
        while (!queue1.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int n=groupSize-1;
            int cur=queue1.poll();
            while (n>0){
                if (queue1.isEmpty())return false;
                int temp=queue1.poll();
                if (temp==cur+1){
                    n--;
                    cur++;
                }else if(temp==cur){
                    list.add(temp);
                }else {
                    return false;
                }
            }
            for (Integer integer : list) {
                queue1.add(integer);
            }
        }
        return true;
    }
}
